package com.spring.bankApp.domain.user;

import org.springframework.stereotype.Service;

@Service
public interface UserDeleter {

    void deleteIdUser(long userId);
    void deleteUserWIthUsername(String username);
}
