package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.bean.po.UserBeanPo;
import com.fh.bean.vo.UserBeanVo;
import com.fh.search.UserSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IMapperUserVo extends BaseMapper<UserBeanVo> {
    IPage<UserBeanVo> queryPageList(Page<UserBeanPo> userBeanPoPage, @Param("userSearch") UserSearch userSearch);
}
