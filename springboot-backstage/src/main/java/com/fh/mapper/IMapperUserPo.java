package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.po.UserBeanPo;
import com.fh.bean.vo.UserBeanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IMapperUserPo extends BaseMapper<UserBeanPo> {
    List<UserBeanVo> querySearchUser(Integer deptId);
}
