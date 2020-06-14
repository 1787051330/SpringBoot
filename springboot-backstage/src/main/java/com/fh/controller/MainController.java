package com.fh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mains")
public class MainController {

    //跳转主页面
    @RequestMapping("main")
    public String main(){
        return "main";
    }
    //跳转组织结构页面
    @RequestMapping("deptUserList")
    public String deptUserList(){
        return "/system/deptUserList";
    }
    //跳转用户赋予角色页面
    @RequestMapping("toOrgin")
    public String toOrgin(){
        return "/system/orgin";
    }
    //跳转角色赋予权限页面
    @RequestMapping("toRoleRight")
    public String toRoleRight(){
        return "/system/roleRight";
    }
    //跳转权限树维护页面
    @RequestMapping("toRightTree")
    public String toRightTree(){
        return "/zTree/rightTree";
    }
    //跳转角色树维护页面
    @RequestMapping("toRoleTree")
    public String toRoleTree(){
        return "/zTree/roleTree";
    }

}
