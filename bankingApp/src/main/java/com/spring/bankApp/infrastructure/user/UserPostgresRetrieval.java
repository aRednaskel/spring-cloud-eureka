package com.spring.bankApp.infrastructure.user;

import com.spring.bankApp.domain.model.user.User;
import com.spring.bankApp.domain.user.UserRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class UserPostgresRetrieval implements UserRetrieval {

    private final UserRepository userRepository;

    @Override
    public User getById(long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByUsername(login);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
