package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.fh.service.IRoleRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("roleRights")
public class RoleRightController {

    @Autowired
    private IRoleRightService roleRightService;

    //查询角色树
    @RequestMapping("queryRoleTree")
    public List<Map<String,Object>> queryRoleTree(){

        return roleRightService.queryRoleTree();
    }
    //通过角色ID查询出拥有的权限树
    @RequestMapping("queryRightTree")
    public List<Map<String,Object>> queryRightTree(Integer roleId){
        return roleRightService.queryRightTree(roleId);
    }

    //给角色赋予权限
    @RequestMapping("addRightToRole")
    public Map addRightToRole(Integer roleId,String rightIds){
        Map map = new HashMap();
        //将rightIDS转为集合
        List<Integer> rightIdsList = JSON.parseArray(rightIds, Integer.class);
        //新增
        roleRightService.addRightToRole(roleId,rightIdsList);
        map.put("code",200);
        return map;
    }

    @RequestMapping("queryRoleRightTree")
    public List<Map<String,Object>> queryRoleRightTree(Integer userId){
        return roleRightService.queryRoleRightTree(userId);
    }

    @RequestMapping("queryRightUserTree")
    public List<Map<String,Object>> queryRightUserTree(Integer roleId){
        return roleRightService.queryRightUserTree(roleId);
    }




}
