package com.net.controller;


import com.net.entity.Log;
import com.net.entity.Users;
import com.net.mapper.LogMapper;
import com.net.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    LogMapper logMapper;
    @Autowired
    PageBean page;

    /**
     * 	日志列表
     * @param pageIndex  当前页码
     * @param begin_date 开始时间
     * @param end_date   结束时间
     * @return 用户列表页码
     */
    @RequestMapping("/list")
    public String userList(String pageIndex,String cause,String begin_date,String end_date,Map<String,Object> map,HttpSession session){
        map.put("cause", cause);
        map.put("begin_date", begin_date);
        map.put("end_date", end_date);
        int count = logMapper.selLog(map).size();
        page=page.getPageBean(pageIndex, count);
        map.put("begin", page.getStartRow());
        map.put("last", page.getEndRow());
        List<Log> logs = logMapper.selLog(map);
        map.put("list",logs);
        map.put("pageBean", page);
        return "log/log-list";
    }

}
