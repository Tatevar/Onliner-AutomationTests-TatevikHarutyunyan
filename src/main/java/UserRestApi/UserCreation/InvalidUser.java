package UserRestApi.UserCreation;

import lombok.Data;

import java.util.List;
@Data
public class InvalidUser {
    public List<String> email;
    public List<String> repeat_password;
    public List<String> password;

}

