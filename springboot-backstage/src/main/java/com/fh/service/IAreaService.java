package com.fh.service;

import com.fh.bean.vo.AreaBeanVo;

import java.util.List;

public interface IAreaService {
    List<AreaBeanVo> areaDept();

    List<AreaBeanVo> queryCity(String code);

    List<AreaBeanVo> queryArea(String code);
}
