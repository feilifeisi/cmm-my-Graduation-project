package com.net.controller;

import com.net.entity.Log;
import com.net.entity.Transfer;
import com.net.entity.Users;
import com.net.mapper.LogMapper;
import com.net.mapper.UsersMapper;
import com.net.utils.PageBean;
import com.net.utils.RETINFO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 	用户业务
 */
@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    PageBean page;
    @Autowired
    LogMapper logMapper;

    /**
     * 	用户列表
     * @param pageIndex  当前页码
     * @param like       关键字
     * @param begin_date 开始时间
     * @param end_date   结束时间
     * @return 用户列表页码
     */
    @RequestMapping("/list")
    public String userList(String pageIndex,String like,Integer role,String sex,
                           String begin_date,String end_date,String fid,Map<String,Object> map,HttpSession session){
    	Users admin =  (Users) session.getAttribute("user_power");
    	if(admin.getRole()==0){
    	    role=null;
        }else if(admin.getRole()==1){
    	    role=2;
        }
    	map.put("users", admin);
    	map.put("like",like);
        map.put("role",role);
        map.put("sex",sex);
        map.put("begin_date", begin_date);
        map.put("end_date", end_date);
        int count = usersMapper.selAll(map).size();
        page=page.getPageBean(pageIndex, count);
        map.put("begin", page.getStartRow());
        map.put("last", page.getEndRow());
        List<Users> users = usersMapper.selAll(map);
        map.put("list",users);
        map.put("pageBean", page);
        return "users/user-list";
    }


    /**
     * 	接口-登录
     * @param session
     * @param user	用户信息 name=&pwd=&role=
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object Login(HttpSession session,Users user){
        Map<String,Object> map = new HashMap<>();
        try {
            if(user != null ) {
                //登录
                Users u = usersMapper.login(user);
                if(u != null){
                    if(u.getStopstate().equals("1")) {
                        session.setAttribute("user_power", u);
                        map.put(RETINFO.CODE, RETINFO.SUCCESS_CODE);
                        map.put(RETINFO.MSG, RETINFO.SUCCESS_MSG);
                        map.put(RETINFO.DATA, u);
                        return map;
                    }else{
                        map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
                        map.put(RETINFO.MSG,"该账号已停用!");
                        return map;
                    }
                }else{
                    map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
                    map.put(RETINFO.MSG,"账户或密码错误!");
                    return map;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put(RETINFO.CODE,RETINFO.FAIL_CODE);
        map.put(RETINFO.MSG,RETINFO.FAIL_MSG);
        return map;
    }
    
    @RequestMapping("/login_out")
    public String LoginOutServlet(HttpSession session) throws Exception {
        session.removeAttribute("user_power");
        return "redirect:/";
    }
    
    //跳转添加界面
    @RequestMapping("/toadd")
    public String toAdd(Map<String,Object> map,int role){
        System.out.println(role);
        map.put("roles",role);
        return "users/user-add";
    }


    //添加
    @RequestMapping("/add")
    @ResponseBody
    public Object add(Users transfer) throws  Exception{
        Map<String,Object> map = new HashMap<>();
        Users uu = usersMapper.findUserByName(transfer.getName());
        if(uu != null) {
            map.put(RETINFO.CODE, RETINFO.FAIL_CODE);
            map.put(RETINFO.MSG, "账户已存在!");
            return map;
        }
        int res = usersMapper.insert(transfer);
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
    	Users users = usersMapper.selectByPrimaryKey(id);
        List<Users> list =usersMapper.findteacher();
        if(users.getRole()==1){
            map.put("list",list);
        }
        map.put("users",users);
        return "users/user-edit";
    }

    //编辑
    @RequestMapping("/edit")
    @ResponseBody
    public Object update(Users u){
        Map<String,Object> map = new HashMap<>();
        try {
            int res = usersMapper.updateByPrimaryKeySelective(u);
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

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public Object del(Users u,HttpSession session) throws  Exception{
        Map<String,Object> map = new HashMap<>();
        Users admin =  (Users) session.getAttribute("user_power");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       String create_time=df.format(new Date());// new Date()为获取当前系统时间
        u.setCreate_time(create_time);
        int res = usersMapper.updateByPrimaryKeySelective(u);
        if(res > 0){
            map.put(RETINFO.CODE,RETINFO.SUCCESS_CODE);
            map.put(RETINFO.MSG,RETINFO.SUCCESS_MSG);
            Log log=new Log();
            if(u.getStopstate().equals("0")) {
                log.setCause("用户id:"+u.getId()+"被用户id:"+admin.getId()+"已停用,时间为:"+create_time);
            }else if(u.getStopstate().equals("1")){
                log.setCause("用户id:"+u.getId()+"被用户id:"+admin.getId()+"已启用,时间为:"+create_time);
            }
            logMapper.addLog(log);
            return map;
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
        int res=usersMapper.deleteByPrimaryKey(id);
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
