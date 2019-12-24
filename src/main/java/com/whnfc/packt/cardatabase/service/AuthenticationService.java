package com.whnfc.packt.cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

/**
 * @author tuchun
 * @version 2019-12-16
 */
public class AuthenticationService {

    private static final long EXPIRATIONTIME = 864_000_00;
    private static final String SIGNINGKEY = "SecretKey";
    private static final String PREFIX = "Bearer";

    public static void addToken(HttpServletResponse response, String username) {

        //生成jwttoken,通过response head中返回给客户端
        String JwtToken = Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
        response.addHeader("Authorization", PREFIX + " " + JwtToken);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    public static Authentication getAuthentication(HttpServletRequest request) {

        //从请求head中获取jwttoken
        String token = request.getHeader("Authorization");
        if (token != null) {
            //解析jwttoken
            String user = Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody().getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }

}
