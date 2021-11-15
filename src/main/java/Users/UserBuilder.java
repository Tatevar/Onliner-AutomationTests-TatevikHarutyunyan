package Users;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class UserBuilder {
     public String email;
     public String password;
    }