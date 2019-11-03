package com.louis.mango.admin.util;

import com.louis.mango.admin.security.GrantedAuthorityImpl;
import com.louis.mango.admin.security.JwtAuthenticatioToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Jwt（json web token） 工具类
 * @quthor haMi
 * @date2019/11/3
 */
public class JwtTokenUtils {

    /**
     * 密钥
     */
    private static final String SECRET = "abcdefgh";

    /**
     * 权限列表
     */
    private static final String AUTHORITIES = "authorities";

    /**
     * 根据请求令牌获取登录认证信息
     * @param request
     * @return
     */
    public static Authentication getAuthenticationFromToken(
            HttpServletRequest request){
        Authentication authentication = null;
        //获取请求携带的令牌
        String token = JwtTokenUtils.getToken(request);
        if (!ObjectUtils.isEmpty(token)){
            //请求令牌不能为空
            if(ObjectUtils.isEmpty(SecurityUtils.getAuthentication())){
                //上下文中 Authentication 为空
                Claims claims = getClaimsFromToken(token);

                if (claims == null){
                    return null;
                }

                String userName = claims.getSubject();
                if (userName == null){
                    return null;
                }

                if (isTokenExpired(token)){
                    return null;
                }

                Object authors = claims.get(AUTHORITIES);

                List<GrantedAuthority> authoritys = new ArrayList<GrantedAuthority>();
                if (!ObjectUtils.isEmpty(authors) && authors instanceof  List){

                    for (Object object:(List) authors){
                        authoritys.add(new GrantedAuthorityImpl((String)((Map) object).get("authority")));
                    }
                }

                authentication = new JwtAuthenticatioToken(userName,null,authoritys,token);
            }
        }else {
            if (validateToken(token,SecurityUtils.getUsername())){
                // 如果上下文中Authentication非空，且请求令牌合法，直接返回当前登录认证信息
                authentication = SecurityUtils.getAuthentication();
            }
        }
        return null;
    }

    /**
     * 获取请求token
     * @param request
     * @return
     */
    private static String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authoriaztion");
        String tokenHead = "Bearer";
        if (ObjectUtils.isEmpty(token)){
            token = request.getHeader("token");
        }else if (token.contains(tokenHead)){
            token = token.substring(tokenHead.length());
        }
        if (ObjectUtils.isEmpty(token)){
            token = null;
        }

        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 验证令牌
     * @param token
     * @param username
     * @return
     */
    public static Boolean validateToken(String token, String username) {
        String userName = getUsernameFromToken(token);
        return (userName.equals(username) && !isTokenExpired(token));
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public static String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
}
