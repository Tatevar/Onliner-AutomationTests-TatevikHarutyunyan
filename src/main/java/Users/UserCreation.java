package Users;

import lombok.Data;

// value object pattern
@Data
public class UserCreation {
    String email, password, confirmPassword;
}



