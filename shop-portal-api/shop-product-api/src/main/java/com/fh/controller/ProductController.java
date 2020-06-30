package com.fh.controller;

import com.fh.annotation.LoginAnnotation;
import com.fh.utils.ResponseServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiezhuang
 * @ClassName ProductController
 * @date 2020/6/29 12:29
 */
@RestController
@RequestMapping("products")
public class ProductController {

    @GetMapping
    @LoginAnnotation
    public ResponseServer test(){
        System.out.println("访问商品服务");
        return ResponseServer.success();
    }

}
