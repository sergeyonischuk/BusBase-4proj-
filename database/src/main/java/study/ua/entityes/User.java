package study.ua.entityes;

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
