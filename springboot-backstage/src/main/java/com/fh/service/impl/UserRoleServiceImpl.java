package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.bean.po.UserRoleBeanPo;
import com.fh.bean.vo.OrginVo;
import com.fh.bean.vo.UserRoleBeanVo;
import com.fh.mapper.IUserRoleMapper;
import com.fh.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleMapper userRoleMapper;

    @Override
    public List<Map<String, Object>> queryUserDept() {
        List<OrginVo> orginList = userRoleMapper.queryOrginList();
        return getOrgin(orginList,"dept_0");
    }

    @Override
    public List<Map<String, Object>> queryRoleTree(Integer userId) {
        return userRoleMapper.queryRoleTree(userId);
    }

    @Override
    @Transactional
    public void addUserRole(Integer userId, List<Integer> roleIdsList) {
        //首先要删除用户拥有的角色
        userRoleMapper.delete(new QueryWrapper<UserRoleBeanPo>().eq("userId",userId));
        //遍历
        roleIdsList.forEach(role->{
            //创建关联表对象
            UserRoleBeanPo userRoleBeanPo = new UserRoleBeanPo();
            //赋值
            userRoleBeanPo.setUserId(userId);
            userRoleBeanPo.setRoleId(role);
            //添加到关联表中
            userRoleMapper.insert(userRoleBeanPo);
        });
    }

    @Override
    public List<UserRoleBeanVo> queryRoleId(Integer userId) {
        return userRoleMapper.queryRoleId(userId);
    }

   /* @Override
    public void addUserRole(Integer userId, List<Integer> roleIdsList) {
        //删除该用户已拥有的角色
        userRoleMapper.delete(new QueryWrapper<UserRoleBeanPo>().eq("userId",userId));
        //循环新增
        roleIdsList.forEach(role->{
            UserRoleBeanPo userRoleBeanPo = new UserRoleBeanPo();
            userRoleBeanPo.setUserId(userId);
            userRoleBeanPo.setRoleId(role);
            userRoleMapper.insert(userRoleBeanPo);
        });
    }*/

    private List<Map<String, Object>> getOrgin(List<OrginVo> orginList,String pid){
        List<Map<String, Object>> list = new ArrayList<>();
        orginList.forEach(orgin->{
            Map<String, Object> map = null;
            if(pid.equals(orgin.getPid())){
                map = new HashMap<>();
                map.put("id",orgin.getId());
                map.put("pid",orgin.getPid());
                map.put("name",orgin.getName());
                if(orgin.getPid().equals("dept_0")){
                    map.put("iconOpen","/static/orgimg/1_open.png");
                    map.put("iconClose","/static/orgimg/organ.png");
                }else if(orgin.getId().contains("dept_")){
                    map.put("icon","/static/orgimg/dept2.png");
                }else{
                    if(orgin.getSex() == 1){
                        map.put("icon","/static/orgimg/nan.png");
                    }else{
                        map.put("icon","/static/orgimg/nv.png");
                    }
                }
                map.put("children",getOrgin(orginList,orgin.getId()));
            }
            if(map != null){
                list.add(map);
            }
        });
        return list;
    }
}
