package com.net.controller;


import com.net.entity.*;
import com.net.mapper.InstrumentMapper;
import com.net.mapper.LogMapper;
import com.net.utils.PageBean;
import com.net.utils.RETINFO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("instrument")
public class InstrumentController {
    @Autowired
    InstrumentMapper instrumentMapper;
    @Autowired
    PageBean page;
    @Autowired
    LogMapper logMapper;

    /**
     * 仪器零件列表
     * @param pageIndex
     * @param begin_date
     * @param end_date
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/list")
    public String selInstrumentList(String pageIndex, String name,String employ,String count,String state,
                                 String begin_date, String end_date, Map<String,Object> map, HttpSession session){
        Users admin =  (Users) session.getAttribute("user_power");
        map.put("users",admin);
        map.put("employ",employ);
        map.put("count",count);
        map.put("state",state);
        map.put("name",name);
        map.put("begin_date", begin_date);
        map.put("end_date", end_date);
        int coun = instrumentMapper.selInstrumentList(map).size();
        page=page.getPageBean(pageIndex, coun);
        map.put("begin", page.getStartRow());
        map.put("last", page.getEndRow());
        List<Instrument> instrument = instrumentMapper.selInstrumentList(map);
        map.put("list",instrument);
        map.put("pageBean", page);
        return "instrument/instrument-list";
    }

    //跳转添加界面
    @RequestMapping("/toadd")
    public String toAdd(Map<String,Object> map){
        return "instrument/instrument-add";
    }


    //添加
    @RequestMapping("/addInstrument")
    @ResponseBody
    public Object addInstrument(Instrument instrument) throws  Exception{
        Map<String,Object> map = new HashMap<>();
        Instrument instru=instrumentMapper.addInstrumentByName(instrument.getName());
        if(instru!=null){
            map.put(RETINFO.CODE, RETINFO.FAIL_CODE);
            map.put(RETINFO.MSG, "仪器名称重复!");
            return map;
        }
        int res = instrumentMapper.addInstrument(instrument);
        if(res > 0){
            map.put(RETINFO.CODE,RETINFO.SUCCESS_CODE);
            map.put(RETINFO.MSG,RETINFO.SUCCESS_MSG);
            return map;
        }
        map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
        map.put(RETINFO.MSG,RETINFO.FAIL_MSG);
        return map;
    }

    //跳转编辑界面
    @RequestMapping("/toedit")
    public String toEdit(Map<String,Object> map,int id){
        Instrument instrument= instrumentMapper.selInstrumentListById(id);
        map.put("instrument",instrument);
        return "instrument/instrument-edit";
    }

    //编辑(带着调用修改)
    @RequestMapping("/updInstrumentList")
    @ResponseBody
    public Object updInstrumentList(Instrument i,HttpSession session){
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String create_time=df.format(new Date());// new Date()为获取当前系统时间
        Users admin =  (Users) session.getAttribute("user_power");
        try {
            i.setUsersId(admin.getId());
            if(i.getYesno()!=null && !i.getYesno().equals("")){
                if(i.getYesno().equals("1")) {
                    Transfer transfer = new Transfer();
                    transfer.setUsersId(admin.getId());
                    transfer.setInstruId(i.getId());
                    int s = (i.getBeingused() + 1);
                    i.setEmploy(s);
                    if (i.getCount() > 0) {
                        i.setCount(i.getCount() - 1);
                    } else {
                        i.setCount(0);
                    }
                    Log log=new Log();
                    log.setCause("用户id:"+admin.getId()+"已调用仪器id:"+i.getId()+",时间为:"+create_time);
                    logMapper.addLog(log);
                    instrumentMapper.inserttransfer(transfer);
                }else if(i.getYesno().equals("0")){
                    i.setCount(i.getCount() + 1);
                    Log log=new Log();
                    log.setCause("用户id:"+admin.getId()+"已取消调用仪器id:"+i.getId()+",时间为:"+create_time);
                    instrumentMapper.deletetransfer(i.getTranId());
                    logMapper.addLog(log);
                }
            }
            int res = instrumentMapper.updInstrumentList(i);
            if (res>0){
                map.put(RETINFO.CODE,RETINFO.SUCCESS_CODE);
                map.put(RETINFO.MSG,RETINFO.SUCCESS_MSG);
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
        map.put(RETINFO.MSG,RETINFO.FAIL_MSG);
        return map;
    }


    /**
     * 用户使用仪器情况表
     * @param pageIndex
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/selInstrumentUsers")
    public String selInstrumentUsers(String pageIndex,Map<String,Object> map,String instruname,String usersname,String state,Integer role,String tel,String sex, HttpSession session){
        Users admin =  (Users) session.getAttribute("user_power");
        Integer usersId=null;
        if(admin.getRole().equals("0")){
            role =null;
        }else if(admin.getRole()==1){
            role=2;
        }else if(admin.getRole()==2){
            usersId=admin.getId();
        }
        map.put("users",admin);
        map.put("instruname",instruname);
        map.put("usersname",usersname);
        map.put("state",state);
        map.put("role",role);
        map.put("tel",tel);
        map.put("sex",sex);
        map.put("usersId",usersId);
        int coun = instrumentMapper.selInstrumentUsers(map).size();
        page=page.getPageBean(pageIndex, coun);
        map.put("begin", page.getStartRow());
        map.put("last", page.getEndRow());
        List<InstruUsers> instruUsers = instrumentMapper.selInstrumentUsers(map);
        map.put("list",instruUsers);
        map.put("pageBean", page);
        return "instrument/instruusers-list";
    }

    /**
     * 报警
     * @param session
     * @return
     */
    @RequestMapping("/selInstrumentBaoJin")
    @ResponseBody
    public Object selInstrumentBaoJin(HttpSession session){
        Map<String,Object> map=new HashMap<>();
        Users admin =  (Users) session.getAttribute("user_power");
        List<Instrument> list=instrumentMapper.selInstrumentBaoJin();
        if(admin.getRole()!=2){
            if(list!=null && list.size()>0) {
                String msg="";
                for (Instrument instrument:list) {
                    if(instrument.getState().equals("1")) {
                        msg += "'" + instrument.getName() + "'仪器，id为：" + instrument.getId() + "。------";
                    }else if(instrument.getState().equals("0")){
                        msg += "'" + instrument.getName() + "'零件，id为：" + instrument.getId() + "。------";
                    }
                }
                msg+="数量较少，请补货！！";

                map.put(RETINFO.CODE,RETINFO.SUCCESS_CODE);
                map.put(RETINFO.MSG,msg);
                return map;
            }else{
                map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
                map.put(RETINFO.MSG,RETINFO.FAIL_MSG);
                return map;
            }
       }
        map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
        map.put(RETINFO.MSG,RETINFO.FAIL_MSG);
        return map;
    }

    //删除
    @RequestMapping("/delet")
    @ResponseBody
    public Object delet(HttpSession session,Integer id) throws  Exception{
        Map<String,Object> map = new HashMap<>();
        int res=instrumentMapper.delet(id);
        if(res > 0){
            map.put(RETINFO.CODE,RETINFO.SUCCESS_CODE);
            map.put(RETINFO.MSG,RETINFO.SUCCESS_MSG);
            return map;
        }
        map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
        map.put(RETINFO.MSG,RETINFO.FAIL_MSG);
        return map;
    }


}
