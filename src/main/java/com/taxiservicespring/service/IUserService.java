package com.taxiservicespring.service;

import com.taxiservicespring.entity.User;

public interface IUserService {
    User getUserByLogin(String login);
    User saveUser(User user);
}
