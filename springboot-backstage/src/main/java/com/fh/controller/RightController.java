package com.fh.controller;

import com.fh.bean.po.RightBeanPo;
import com.fh.service.impl.RightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("rights")
public class RightController {

    @Autowired
    private RightServiceImpl rightService;

    //查询权限ztree树
    @RequestMapping("queryRightTree")
    public List<Map<String,Object>> queryRightTree(){
        return rightService.queryRightTree();
    }

    //新增权限ztree树
    @RequestMapping("addRight")
    public Map addRight(RightBeanPo rightBeanPo){
        Map map = new ConcurrentHashMap();
        try {
            //执行添加方法
         RightBeanPo right = rightService.addRight(rightBeanPo);
         map.put("code",200);
         map.put("right",right);
        }catch (Exception e){
            map.put("message",e.getMessage());
        }
        return map;
    }

    //修改权限ztree树
    @RequestMapping("updateRight")
    public Map updateRight(RightBeanPo rightBeanPo){
        Map map = new ConcurrentHashMap();
        try {
            RightBeanPo right = rightService.addRight(rightBeanPo);
            map.put("code",200);
            map.put("data",right);
        }catch (Exception e){
            map.put("messgae",e.getMessage());
        }

        return map;
    }

    @RequestMapping("queryRightById")
    public Map queryRightById(Integer rightId){
        Map map = new ConcurrentHashMap();
        RightBeanPo rightBeanPo = rightService.queryRightById(rightId);
        map.put("right",rightBeanPo);
        return map;
    }


}
