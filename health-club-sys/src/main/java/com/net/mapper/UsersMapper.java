package com.net.mapper;

import java.util.List;
import java.util.Map;

import com.net.entity.Transfer;
import org.mybatis.spring.annotation.MapperScan;

import com.net.entity.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    List<Users> selAll(Map<String, Object> map);
    
    Users login(Users users);
    
    Users findUserByName(String name);
    List<Users> findteacher();
}