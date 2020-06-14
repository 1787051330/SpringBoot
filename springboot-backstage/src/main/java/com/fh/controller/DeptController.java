package com.fh.controller;

import com.fh.bean.po.DeptBeanPo;
import com.fh.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("depts")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("queryDeptTree")
    @ResponseBody
    public List<Map<String,Object>> queryDeptTree(){
        return deptService.queryDeptTree();
    }

    @RequestMapping("addDept")
    @ResponseBody
    public Map addDept(DeptBeanPo deptBeanPo){
        Map map = new HashMap();
        DeptBeanPo dept = deptService.addDept(deptBeanPo);
        map.put("dept",dept);
        map.put("code",200);
        map.put("msg","添加成功");
        return map;
    }

    @RequestMapping("queryDeptId")
    @ResponseBody
    public DeptBeanPo queryDeptId(Integer deptId){
        return deptService.queryDeptId(deptId);
    }

    @RequestMapping("deptUpdate")
    @ResponseBody
    public Map deptUpdate(DeptBeanPo deptBeanPo){
        Map map = new HashMap();
        deptBeanPo.setStatus(1);
        deptService.deptUpdate(deptBeanPo);
        map.put("code",200);
        map.put("data",deptBeanPo);
        return map;
    }

    @RequestMapping("delDept")
    @ResponseBody
    public Map delDept(Integer deptId){
        Map map = new HashMap();
        deptService.delDept(deptId);
        map.put("code",200);
        return map;
    }


}
