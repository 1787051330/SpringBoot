package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.po.RoleBeanPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IRoleMapper extends BaseMapper<RoleBeanPo> {
    List<Map<String, Object>> queryTreeRole();
}
