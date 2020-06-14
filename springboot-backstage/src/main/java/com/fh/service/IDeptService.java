package com.fh.service;

import com.fh.bean.po.DeptBeanPo;

import java.util.List;
import java.util.Map;

public interface IDeptService {
    List<Map<String, Object>> queryDeptTree();

    DeptBeanPo addDept(DeptBeanPo deptBeanPo);

    DeptBeanPo queryDeptId(Integer deptId);

    void deptUpdate(DeptBeanPo deptBeanPo);

    void delDept(Integer deptId);
}
