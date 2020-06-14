package com.fh.service.impl;

import com.fh.bean.vo.AreaBeanVo;
import com.fh.mapper.IAreaMapper;
import com.fh.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private IAreaMapper areaMapper;

    @Override
    public List<AreaBeanVo> areaDept() {
        return areaMapper.areaDept();
    }

    @Override
    public List<AreaBeanVo> queryCity(String code) {
        return areaMapper.queryCity(code);
    }

    @Override
    public List<AreaBeanVo> queryArea(String code) {
        return areaMapper.queryArea(code);
    }
}
