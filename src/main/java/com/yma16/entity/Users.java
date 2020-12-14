package com.yma16.entity;

import lombok.Data;//简便生成get、set方法 lombok


@Data
public class Users {
    private Integer id;
    private String username,password;
}
