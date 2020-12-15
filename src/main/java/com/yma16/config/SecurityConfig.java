package com.yma16.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());//加密
    }
    @Bean
    PasswordEncoder password()
    {
        return new BCryptPasswordEncoder();//注解
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //自定义登录页
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/user/login").defaultSuccessUrl("/test/index").
                permitAll().and().authorizeRequests().antMatchers("/","/test/hello").permitAll()
                .anyRequest().authenticated().and().csrf().disable();//关闭csrf
//        http.formLogin().and().authorizeRequests().anyRequest().authenticated();//身份验证
//        http.authorizeRequests().anyRequest("","").permitAll().anyRequest().authenticated();
    }
}
