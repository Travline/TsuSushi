package Core.Database;

import Core.KeyManager;
import java.sql.*;

public class ConnectionDB {
    private String url;
    private Connection conn;
    
    public ConnectionDB() {
        this.url = new KeyManager().DatabaseURL();
    }
    
    public Connection connect() throws SQLException {
        if (this.conn == null || this.conn.isClosed()) {
            this.conn = DriverManager.getConnection(this.url);
        }
        return this.conn;
    }
    
    public void disconnect() throws SQLException{
        if (!(this.conn == null || this.conn.isClosed())) {
            this.conn.close();
        }
    }
}