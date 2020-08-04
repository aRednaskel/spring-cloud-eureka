package com.spring.bankApp.domain.user;

import com.spring.bankApp.domain.model.user.Gender;
import com.spring.bankApp.domain.model.user.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCommand {
    private String login;
    private Gender gender;
    private String password;

    public User createUser() {
        return User.createUser(login, gender, password);
    }

}
