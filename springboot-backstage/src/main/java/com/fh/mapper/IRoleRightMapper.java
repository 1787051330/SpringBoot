package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.po.RoleRightBeanPo;
import com.fh.bean.vo.RightUserBeanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IRoleRightMapper extends BaseMapper<RoleRightBeanPo> {

    List<Map<String, Object>> queryRoleTree();

    List<Map<String, Object>> queryRightTree(Integer roleId);

    List<Map<String, Object>> queryRoleRightTree(Integer userId);

    List<RightUserBeanVo> queryRightUserTree(Integer roleId);
}
