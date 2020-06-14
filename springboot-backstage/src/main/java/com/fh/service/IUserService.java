package com.fh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.bean.po.UserBeanPo;
import com.fh.bean.vo.UserBeanVo;
import com.fh.search.UserSearch;

import java.util.List;

public interface IUserService {
    List<UserBeanPo> queryListUser();

    List<UserBeanVo> querySearchUser(Integer deptId);

    IPage<UserBeanVo> queryPageList(Page<UserBeanPo> userBeanPoPage, UserSearch userSearch);

    void addDeptUser(UserBeanPo userBeanPo);

    UserBeanPo queryUserById(Integer userId);

    void delUser(Integer userId);
}
