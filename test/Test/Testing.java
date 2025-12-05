package Test;

import org.junit.jupiter.api.*;
import Public.User.*;
import java.sql.*;

public class Testing {
    @Test
    void login() {
        try {
            UserController userController = new UserController();
            userController.login("159159");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
    }
}