package com.fh.annotation;

import com.fh.jwt.JwtUtils;
import com.fh.utils.ResponseServer;
import com.fh.utils.ServerEnum;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiezhuang
 * @ClassName LoginAop
 * @date 2020/6/29 12:11
 */
@Component
@Aspect
@Order(1)
public class LoginAop {

    @Value("${token.headerToken}")
    private String headerToken;

    @Value("${token.securityKey}")
    private String securityKey;


    @Autowired
    private HttpServletRequest request;

    @Around("execution(* com.fh.controller..*.*(..)) && @annotation(loginAnnotation))")
    public Object loginAroud(ProceedingJoinPoint joinPoint , LoginAnnotation loginAnnotation){
        //前置通知
        //根据头部信息获取token
        String token = request.getHeader(headerToken);
        //判断token不为空
        if(StringUtils.isBlank(token)){
            return ResponseServer.error(ServerEnum.TOKEN_ISNULL);
        }
        //验证token值
        ResponseServer responseServer = JwtUtils.resolveToken(token, securityKey);
        int size = 200;
        if(responseServer.getCode() != size){
            return responseServer;
        }
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            //抛出异常后通知
            throwable.printStackTrace();
        }finally {
            //后置通知
        }
        return obj;
    }

}
