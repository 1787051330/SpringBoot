package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.fh.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("userRoles")
public class UserRoleController {

    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping("queryUserDept")
    public List<Map<String,Object>> queryUserDept(){
        return userRoleService.queryUserDept();
    }

    @RequestMapping("queryRoleTree")
    public List<Map<String, Object>> queryRoleTree(Integer userId){
        return userRoleService.queryRoleTree(userId);
    }

/*
    //给用户赋予角色
    @RequestMapping("addUserRole")
    public Map addUserRole(Integer userId,String roleIds){
        Map map = new HashMap();
        List<Integer> roleIdsList = JSON.parseArray(roleIds, Integer.class);
        userRoleService.addUserRole(userId,roleIdsList);
        map.put("code",200);
        return map;
    }*/


    @RequestMapping("addUserRole")
    public Map addUserRole(Integer userId,String roleIds){
        Map map = new HashMap();
        //转换roleIds
        List<Integer> roleIdsList = JSON.parseArray(roleIds, Integer.class);
        //添加数据
        userRoleService.addUserRole(userId,roleIdsList);
        //添加成功返回{code:200}
        map.put("code",200);
        return map;
    }

}
