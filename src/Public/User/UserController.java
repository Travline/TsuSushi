package Public.User;

import java.sql.SQLException;

public class UserController {
    public Boolean login(String user_code) throws SQLException{
            UserRepository repo = new UserRepository();
            var data = repo.findUser(user_code);
            if (data == null) {
                return false;
            }
            UserLoged userLoged = UserLoged.getInstance();
            userLoged.setName(data.getName());
            userLoged.setCode(data.getCode());
            userLoged.setRole(data.getRole());
            userLoged.setStatus(data.getStatus());
            userLoged.setCreated(data.getCreated());
            return true;
    }
}
