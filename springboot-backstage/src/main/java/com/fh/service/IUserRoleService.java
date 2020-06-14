package com.fh.service;

import com.fh.bean.vo.UserRoleBeanVo;

import java.util.List;
import java.util.Map;

public interface IUserRoleService {
    List<Map<String, Object>> queryUserDept();

    List<Map<String, Object>> queryRoleTree(Integer userId);

    void addUserRole(Integer userId, List<Integer> roleIdsList);

    List<UserRoleBeanVo> queryRoleId(Integer userId);

    //void addUserRole(Integer userId, List<Integer> roleIdsList);
}
