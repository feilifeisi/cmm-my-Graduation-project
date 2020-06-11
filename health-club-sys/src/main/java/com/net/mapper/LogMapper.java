package com.net.mapper;

import com.net.entity.Log;

import java.util.List;
import java.util.Map;

public interface LogMapper {

    int addLog(Log log);

    List<Log> selLog(Map<String,Object> map);
}
