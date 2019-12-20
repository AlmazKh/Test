package ru.itis;

import lombok.*;

@Setter
@Getter
@Builder
public class User {

    private String login;
    private String password;

}
