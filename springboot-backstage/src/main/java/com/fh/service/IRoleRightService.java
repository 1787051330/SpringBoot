package com.fh.service;

import java.util.List;
import java.util.Map;

public interface IRoleRightService {
    List<Map<String, Object>> queryRoleTree();

    List<Map<String, Object>> queryRightTree(Integer roleId);

    void addRightToRole(Integer roleId, List<Integer> rightIdsList);

    List<Map<String, Object>> queryRoleRightTree(Integer userId);

    List<Map<String, Object>> queryRightUserTree(Integer roleId);
}
