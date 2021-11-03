package Patterns;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class UserBuilder {
     public String username;
     public String password;
    }