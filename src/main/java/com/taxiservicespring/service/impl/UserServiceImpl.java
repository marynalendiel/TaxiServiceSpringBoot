package com.taxiservicespring.service.impl;

import com.taxiservicespring.entity.User;
import com.taxiservicespring.repository.UserRepository;
import com.taxiservicespring.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void updateUserDiscount(int id, int discount) {
        userRepository.updateDiscount(id, discount);
    }
}
