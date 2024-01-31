package com.airbnb.service;

import com.airbnb.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
