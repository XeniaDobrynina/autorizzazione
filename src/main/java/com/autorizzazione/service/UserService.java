package com.autorizzazione.service;

import com.autorizzazione.model.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity save(UserEntity user);

    UserEntity findByEmail(String email);
}
