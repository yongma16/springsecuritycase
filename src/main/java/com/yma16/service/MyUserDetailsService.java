package com.yma16.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yma16.entity.Users;
import com.yma16.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersMapper usersMapper;//  Reposotory
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //根据用户名查询
        QueryWrapper<Users> wrapper=new QueryWrapper();
        //where 语句 where usename=?
        wrapper.eq("username",username);
        Users users=usersMapper.selectOne(wrapper);
        if(users==null)
        {//没有该用户
            throw new UsernameNotFoundException("没有该用户！");//抛出错误
        }

        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),auths);//
//        return new User("yma16",new BCryptPasswordEncoder().encode("123456"),auths);
    }
}
