package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.po.UserRoleBeanPo;
import com.fh.bean.vo.OrginVo;
import com.fh.bean.vo.UserRoleBeanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IUserRoleMapper extends BaseMapper<UserRoleBeanPo> {
    List<OrginVo> queryOrginList();

    List<Map<String, Object>> queryRoleTree(Integer userId);

    List<UserRoleBeanVo> queryRoleId(Integer userId);
}
