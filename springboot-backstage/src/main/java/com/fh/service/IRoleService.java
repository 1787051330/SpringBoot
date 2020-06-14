package com.fh.service;

import com.fh.bean.po.RoleBeanPo;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    List<Map<String, Object>> queryTreeRole();

    RoleBeanPo addRoleTree(RoleBeanPo roleBeanPo);

    RoleBeanPo queryRoleTreeId(Integer roleId);
}
