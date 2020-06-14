package com.fh.mapper;

import com.fh.bean.vo.AreaBeanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IAreaMapper {
    List<AreaBeanVo> areaDept();

    List<AreaBeanVo> queryCity(String code);

    List<AreaBeanVo> queryArea(String code);
}
