package ru.itis;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User {

    private String login;
    private String password;

}
