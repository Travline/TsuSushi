package Public.User;

public class UserLoged extends UserBaseModel{
    private static UserLoged instance;
    
    private UserLoged() {
        
    }

    public static UserLoged getInstance() {
        if (instance == null) {
            instance = new UserLoged();
        }
        return instance;
    }
}
