package Public.Menu;

import Core.Database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;

public class FoodRepository {
    public HashSet<String> foodList() throws SQLException {
        try (Connection conn = new ConnectionDB().connect()) {
                String query = "SELECT food_name "+
                                "FROM menu"; 
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);

                HashSet<String> response = new HashSet<>();
                while(rs.next()) {
                    response.add(rs.getString("food_name"));
                }
                return response; 
            }
    }   
    
    public FoodBaseModel foodData(String food_name) throws SQLException{    
        try (Connection conn = new ConnectionDB().connect()) {
                String query = "SELECT food_name, info, price, category, created "+
                                "FROM menu WHERE food_name = ?"; 
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, food_name);
                ResultSet rs = pst.executeQuery();
                FoodBaseModel response = new FoodBaseModel();
                while(rs.next()) {
                    response.setFood_name(rs.getString("food_name"));
                    response.setInfo(rs.getString("info"));
                    response.setPrice(rs.getDouble("price"));
                    response.setCategory(rs.getString("category"));
                    response.setCreated(rs.getObject("created", LocalDateTime.class));
                    return response;
                }
                return null;
            }
    }
}
