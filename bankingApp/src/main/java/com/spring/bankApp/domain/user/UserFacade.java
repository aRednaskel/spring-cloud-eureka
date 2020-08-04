package com.spring.bankApp.domain.user;


import com.spring.bankApp.domain.model.user.Gender;
import com.spring.bankApp.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade implements UserDetailsService {

    private final UserCreator userCreator;
    private final UserRetrieval userRetrieval;
    private final UserUpdate userUpdate;

    public void createUser(String login, Gender gender, String password) {
        userCreator.create(login, gender, password);
    }

    public void createUserAndPremiumAccount(String login, Gender gender, String password) {
        userCreator.createUserAndPremiumAccount(login, gender, password);
    }

    public void createUserAndStandardAccount(String login, Gender gender, String password) {
        userCreator.createUserAndStandardAccount(login, gender, password);
    }

    public void updatePassword(String login, String oldPassword, String newPassword) {
        userUpdate.updatePassword(login, oldPassword, newPassword);
    }

    public void updateLogin(String oldLogin, String newLogin, String password) {
        userUpdate.updateLogin(oldLogin,newLogin, password);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRetrieval.getByLogin(username);
    }

    public List<User> findAllUsers() {
        return userRetrieval.findAll();
    }
}
