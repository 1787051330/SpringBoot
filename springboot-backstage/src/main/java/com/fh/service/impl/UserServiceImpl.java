package com.fh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.bean.po.UserBeanPo;
import com.fh.bean.vo.UserBeanVo;
import com.fh.mapper.IMapperUserPo;
import com.fh.mapper.IMapperUserVo;
import com.fh.search.UserSearch;
import com.fh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IMapperUserPo mapperUserPo;
    @Autowired
    private IMapperUserVo mapperUserVo;

    @Override
    public List<UserBeanPo> queryListUser() {
        return mapperUserPo.selectList(null);
    }

    @Override
    public List<UserBeanVo> querySearchUser(Integer deptId) {
        return mapperUserPo.querySearchUser(deptId);
    }

    @Override
    public IPage<UserBeanVo> queryPageList(Page<UserBeanPo> userBeanPoPage, UserSearch userSearch) {
        return mapperUserVo.queryPageList(userBeanPoPage,userSearch);
    }

    @Override
    public void addDeptUser(UserBeanPo userBeanPo) {
        if(userBeanPo.getId() == null || userBeanPo.getId() == 0){
            mapperUserPo.insert(userBeanPo);
        }else {
            mapperUserPo.updateById(userBeanPo);
        }

    }

    @Override
    public UserBeanPo queryUserById(Integer userId) {
        return mapperUserPo.selectById(userId);
    }

    @Override
    public void delUser(Integer userId) {
        mapperUserPo.deleteById(userId);
    }
}
