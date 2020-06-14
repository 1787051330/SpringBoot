package com.fh.service.impl;

import com.fh.bean.po.RoleBeanPo;
import com.fh.mapper.IRoleMapper;
import com.fh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> queryTreeRole() {
        return roleMapper.queryTreeRole();
    }

    @Override
    public RoleBeanPo addRoleTree(RoleBeanPo roleBeanPo) {
        if(roleBeanPo.getId() == null){
            roleMapper.insert(roleBeanPo);
        }else{
            roleMapper.updateById(roleBeanPo);
        }
        return roleBeanPo;
    }

    @Override
    public RoleBeanPo queryRoleTreeId(Integer roleId) {
        return roleMapper.selectById(roleId);
    }
}
