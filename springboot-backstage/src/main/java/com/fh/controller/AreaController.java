package com.fh.controller;

import com.fh.bean.vo.AreaBeanVo;
import com.fh.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @RequestMapping("areaDept")
    public List<AreaBeanVo> areaDept(){

        return areaService.areaDept();
    }

    @RequestMapping("queryCity")
    public List<AreaBeanVo> queryCity(String code){
        return areaService.queryCity(code);
    }

    @RequestMapping("queryArea")
    public List<AreaBeanVo> queryArea(String code){
        return areaService.queryArea(code);
    }


}
