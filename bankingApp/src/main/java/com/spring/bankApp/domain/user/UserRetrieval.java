package com.spring.bankApp.domain.user;

import com.spring.bankApp.domain.model.user.User;

import java.util.List;

public interface UserRetrieval {

    User getById(long userId);

    User getByLogin(String login);

    List<User> findAll();
}
