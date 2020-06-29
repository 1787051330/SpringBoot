package com.fh.utils.jwt;

import com.fh.utils.ResponseServer;
import com.fh.utils.ServerEnum;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiezhuang
 * @ClassName jwtUtils
 * @date 2020/6/28 18:23
 */
public class jwtUtils {

    /**
     * 生成token的方法
     * @param payLoad
     * @param securityKey
     * @return
     */
    public static String createToken(Map<String,Object> payLoad,String securityKey){
        //头部信息
        Map<String,Object> headMap = new HashMap<>();
        headMap.put("alg","HS256");
        headMap.put("type","JWT");

        long time = System.currentTimeMillis();
        long expTime = time+120000L;
        //生成jwt的token值
        String token = Jwts.builder()
                .setHeader(headMap)
                .setClaims(payLoad)
                .setExpiration(new Date(expTime))
                .signWith(SignatureAlgorithm.HS256,securityKey)
                .compact();
        return token;
    }

    /**
     * 解析token的方法
     * @param token
     * @param securityKey
     * @return
     */

    public static ResponseServer resolveToken(String token,String securityKey){
        try {
            Jwts.parser()
                    .setSigningKey(securityKey)
                    .parseClaimsJws(token)
                    .getBody();
            return ResponseServer.success();
        }catch (SignatureException e){
            return ResponseServer.error(ServerEnum.SAFETY_INVALID);
        }catch (ExpiredJwtException e){
            return ResponseServer.error(ServerEnum.TOKEN_TIMEOUT);
        }catch (Exception e){
            return ResponseServer.error();
        }


    }

}
