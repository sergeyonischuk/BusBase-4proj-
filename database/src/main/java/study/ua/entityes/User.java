package study.ua.entityes;

import lombok.extern.log4j.Log4j;
import study.ua.enums.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    private String login;
    private String password;
    private UserType type;
}
