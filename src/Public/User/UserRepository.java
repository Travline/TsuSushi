package Public.User;

import Core.Database.ConnectionDB;
import java.sql.*;
import java.time.LocalDateTime;

public class UserRepository {
  public UserBaseModel findUser(String user_code) throws SQLException { 
        try (Connection conn = new ConnectionDB().connect()) {
            String query = "SELECT user_name, user_code, user_role, user_state, created "+
                            "FROM users WHERE user_code = ? AND user_state = FALSE;"; 
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, user_code);
            ResultSet rs = pst.executeQuery();
            UserBaseModel response = new UserBaseModel();
            while(rs.next()) {
                response.setName(rs.getString("user_name"));
                response.setCode(rs.getString("user_code"));
                response.setRole(rs.getString("user_role"));
                response.setStatus(rs.getBoolean("user_state"));
                response.setCreated(rs.getObject("created", LocalDateTime.class));
                return response;
            }
            return null;
        }
    }
}