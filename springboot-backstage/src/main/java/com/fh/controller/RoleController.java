package com.fh.controller;

import com.fh.bean.po.RoleBeanPo;
import com.fh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("queryTreeRole")
    public List<Map<String,Object>> queryTreeRole(){
        return roleService.queryTreeRole();
    }

    @RequestMapping("addRoleTree")
    public Map addRoleTree(RoleBeanPo roleBeanPo){
        Map map = new ConcurrentHashMap();
        try {
            RoleBeanPo roleBean = roleService.addRoleTree(roleBeanPo);
            map.put("code",200);
            map.put("role",roleBean);
        }catch (Exception e){
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("queryRoleTreeId")
    public Map queryRoleTreeId(Integer roleId){
        Map map = new HashMap();
        RoleBeanPo roleBeanPo = roleService.queryRoleTreeId(roleId);
        map.put("role",roleBeanPo);
        return map;
    }

}
