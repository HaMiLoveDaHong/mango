package com.louis.mango.admin.security;

import com.louis.mango.admin.util.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 身份验证提供者
 * @quthor haMi
 * @date2019/11/3
 */
@Slf4j
public class JwtAuthenticationProvider extends DaoAuthenticationProvider {

    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {
        setUserDetailsService(userDetailsService);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
            if (authentication.getCredentials() == null){
                log.debug("Authentication failed:no credentials provided");
                throw new BadCredentialsException(
                        messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials","Bad credentials"));
            }

            String presentedPassword = authentication.getCredentials().toString();
            String salt = ((JwtUserDetails)userDetails).getSalt();
            if(!new PasswordEncoder(salt).matches(userDetails.getPassword(),presentedPassword)){
                //覆写密码验证逻辑
                log.debug("Authentication failed;password does not match");
                throw new BadCredentialsException(
                        messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials","Bad credentials"));
            }
    }
}
