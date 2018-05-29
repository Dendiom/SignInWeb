package com.example.signinweb.service;

import com.example.signinweb.bean.Result;
import com.example.signinweb.bean.User;

public interface UserService {
    Result register(String username, String password);
    Result login(String username, String password);
    Result perfectInfo(User user);
    Result getUserInfo(long id);
}
