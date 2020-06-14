package com.fh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.bean.po.UserBeanPo;
import com.fh.bean.vo.UserBeanVo;
import com.fh.search.UserSearch;
import com.fh.service.IUserService;
import com.fh.utils.MD5Code;
import com.fh.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("queryListUser")
    @ResponseBody
    public List<UserBeanPo> queryListUser(){

        return userService.queryListUser();
    }

    //根据树节点ID查询用户表
    @RequestMapping("querySearchUser")
    @ResponseBody
    public Map querySearchUser(Integer deptId){
        Map map = new HashMap();
        List<UserBeanVo> userBeanVo = userService.querySearchUser(deptId);
        map.put("code",200);
        map.put("msg","查询成功");
        map.put("userSearch",userBeanVo);
        return map;
    }

    @RequestMapping("queryUserSearchList")
    @ResponseBody
    public PageUtils queryUserSearchList(PageUtils pageUtils, UserSearch userSearch){
        Page<UserBeanPo> userBeanPoPage = new Page<>(pageUtils.getPage(),pageUtils.getLimit());
        IPage<UserBeanVo> iPage = userService.queryPageList(userBeanPoPage,userSearch);
        return new PageUtils(iPage.getRecords(),iPage.getTotal());
    }

    @RequestMapping("addDeptUser")
    @ResponseBody
    public Map addDeptUser(UserBeanPo userBeanPo){
        Map map = new HashMap();
        userBeanPo.setStatus(1);
        userBeanPo.setPassword("123456");
        String password = userBeanPo.getPassword();
        String s = MD5Code.Md5(password);
        System.out.println(s);
        userBeanPo.setPassword(s);
        userService.addDeptUser(userBeanPo);
        map.put("code",200);
        map.put("msg","添加成功,用户默认密码为“123456”");
        return map;
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public UserBeanPo queryUserById(Integer userId){
        return userService.queryUserById(userId);
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public Map updateUser(UserBeanPo userBeanPo){
        Map map = new HashMap();
        userService.addDeptUser(userBeanPo);
        map.put("code",200);
        return map;
    }
    @RequestMapping("delUser")
    @ResponseBody
    public Map delUser(Integer userId){
        Map map = new HashMap();
        userService.delUser(userId);
        map.put("code",200);
        return map;
    }

}
