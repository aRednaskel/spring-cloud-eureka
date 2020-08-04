package com.spring.bankApp.domain.user;


import com.spring.bankApp.domain.model.user.Gender;

public interface UserCreator {

    void create(String login, Gender gender, String password);

    void createUserAndPremiumAccount(String login, Gender gender, String password);

    void createUserAndStandardAccount(String login, Gender gender, String password);

}
