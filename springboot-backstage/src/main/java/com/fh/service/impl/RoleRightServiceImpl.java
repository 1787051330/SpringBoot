package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.bean.po.RoleRightBeanPo;
import com.fh.bean.vo.RightUserBeanVo;
import com.fh.mapper.IRoleRightMapper;
import com.fh.service.IRoleRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleRightService")
public class RoleRightServiceImpl implements IRoleRightService {

    @Autowired
    private IRoleRightMapper roleRightMapper;

    @Override
    public List<Map<String, Object>> queryRoleTree() {
        return roleRightMapper.queryRoleTree();
    }

    @Override
    public List<Map<String, Object>> queryRightTree(Integer roleId) {
        return roleRightMapper.queryRightTree(roleId);
    }

    @Override
    //SpringBoot没有事务 这个注解开启事务防止删除方法运行之后就异常
    @Transactional
    public void addRightToRole(Integer roleId, List<Integer> rightIdsList) {
        //将用户所拥有的权限删除
        roleRightMapper.delete(new QueryWrapper<RoleRightBeanPo>().eq("roleId",roleId));
        //进行循环添加
        rightIdsList.forEach(right->{
            //创建一个实例
            RoleRightBeanPo roleRightBeanPo = new RoleRightBeanPo();
            //set角色表ID
            roleRightBeanPo.setRoleId(roleId);
            //set权限表ID
            roleRightBeanPo.setRightId(right);
            //将权限表ID和角色表ID添加到角色权限关联表中
            roleRightMapper.insert(roleRightBeanPo);
        });
    }

    @Override
    public List<Map<String, Object>> queryRoleRightTree(Integer userId) {
        return roleRightMapper.queryRoleRightTree(userId);
    }

    @Override
    public List<Map<String, Object>> queryRightUserTree(Integer roleId) {
        List<RightUserBeanVo> rightUserBeanVos = roleRightMapper.queryRightUserTree(roleId);
        return getRightUserTree(rightUserBeanVos,"dept_0");
    }

    private List<Map<String, Object>> getRightUserTree(List<RightUserBeanVo> rightUserBeanVos,String pid){
        List<Map<String, Object>> list = new ArrayList<>();
        rightUserBeanVos.forEach(ruser->{
            Map map = null;
            if(pid.equals(ruser.getPid())){
                map = new HashMap();
                map.put("id",ruser.getId());
                map.put("name",ruser.getName());
                map.put("pid",ruser.getPid());
                map.put("nocheck",ruser.getNocheck());
                map.put("checked",ruser.getChecked());
                if(ruser.getPid().equals("dept_0")){
                    map.put("iconOpen","/static/orgimg/1_open.png");
                    map.put("iconClose","/static/orgimg/organ.png");
                }else if(ruser.getId().contains("dept_")){
                    map.put("icon","/static/orgimg/dept2.png");
                }else{
                    if(ruser.getSex() == 1){
                        map.put("icon","/static/orgimg/nan.png");
                    }else{
                        map.put("icon","/static/orgimg/nv.png");
                    }
                }
                map.put("children",getRightUserTree(rightUserBeanVos,ruser.getId()));
            }
            if(map != null){
                list.add(map);
            }
        });
        return list;
    }

}
