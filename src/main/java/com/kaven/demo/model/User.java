package com.kaven.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Kaven
 * @date 2018/10/10 16:40
 */
public class User {

    // 用户名
    @NotEmpty(message = "用户名不能为空")
    private String username;

    //用户密码
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6,max = 16,message = "密码长度为6-16位")
    private  String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
