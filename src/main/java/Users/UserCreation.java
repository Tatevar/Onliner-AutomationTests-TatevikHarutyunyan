package Users;

import lombok.Data;

// value object pattern
@Data
public class UserCreation {
    String email, password, repeat_password;
}



