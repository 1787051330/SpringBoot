package com.fh.controller;

import com.fh.po.ShopUserBeanPo;
import com.fh.service.IUserService;
import com.fh.utils.ResponseServer;
import com.fh.utils.ServerEnum;
import com.fh.utils.jwt.jwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserController
 * @author xiezhuang
 * @date 2020/6/27 17:49
 */
@RestController
@RequestMapping("users")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IUserService userService;

    @Value("${token.securityKey}")
    private String securityKey;

   /* @GetMapping
    public ResponseServer login(String userName, String password){
        log.info("==========登录方法执行=========");
        System.out.println("获取到的用户名为:"+userName+"获取到的密码为:"+password);
        log.info("==========登录方法结束=========");
        return ResponseServer.success(ServerEnum.LOGIN_SUCCESS);
    }*/

    /**
     * 发送验证码
     * @param phone
     * @return
     */
   @GetMapping
    public ResponseServer SendMessage(String phone){
        if(StringUtils.isBlank(phone)){
            return ResponseServer.error(ServerEnum.PHONE_ISNULL);
        }
       //MessageCode.queryTest(phone);
       String code = "123456";
       if(code != null){
           redisTemplate.opsForValue().set("code_"+phone,code,2, TimeUnit.MINUTES);
       }
       return ResponseServer.success(ServerEnum.CODE_SUCCESS);
   }

    /**
     * 登录方法
     * @param phone
     * @return
     */
   @PostMapping
    public ResponseServer login(String phone,String code){
        //首先判断手机号和验证码是否为空
       if(StringUtils.isBlank(phone) || StringUtils.isBlank(code)){
           return ResponseServer.error(ServerEnum.LOGIN_PHONEORCODE_INNULL);
       }
       //获取验证码进行比对
       String redisCode = (String) redisTemplate.opsForValue().get("code_" + phone);
       if(!code.equals(redisCode)){
           return ResponseServer.error(ServerEnum.LOGIN_CODE_ERROR);
       }
       //去数据库中取出对应的数据如果没有则进行添加
        ShopUserBeanPo shopUserBeanPo = userService.queryShopUser(phone);
       //将用户信息放入redis中
        redisTemplate.opsForValue().set("user_"+phone,shopUserBeanPo,1L,TimeUnit.HOURS);
        //生成jwt的字符串
        Map<String,Object> map = new HashMap<>();
        map.put("userId",shopUserBeanPo.getShopId());
        map.put("phone",shopUserBeanPo.getPhone());
        map.put("cartId",shopUserBeanPo.getCartId());
        String token = jwtUtils.createToken(map, securityKey);
        //注册/登录成功之后删除redis中的验证码
        redisTemplate.delete("code_"+phone);
        return ResponseServer.success(token);
   }

}
