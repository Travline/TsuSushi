package Core;

import io.github.cdimascio.dotenv.Dotenv;

public class KeyManager {
    
    private String db_url;
    
    public KeyManager() {
        Dotenv dotenv = Dotenv.configure().load();
        this.db_url = dotenv.get("DATABASE_URL");
    }
    
    public String DatabaseURL() {
        return this.db_url;
    }    
}