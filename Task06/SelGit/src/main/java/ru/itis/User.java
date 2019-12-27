package ru.itis;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String login;
    private String password;

}
