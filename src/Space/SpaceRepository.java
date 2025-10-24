package Space;

import Core.Database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SpaceRepository {
    public ArrayList<SpaceBaseModel> spaceListData() throws SQLException {
        try (Connection conn = new ConnectionDB().connect()) {
            String query = "SELECT space_id, space_state, serving "+
                            "FROM spaces"; 
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            ArrayList<SpaceBaseModel> response = new ArrayList<>();
            while(rs.next()) {
                /* Va del M1 al M14 y C0 */
                SpaceBaseModel space = new SpaceBaseModel();
                space.setSpace_id(rs.getString("space_id"));
                space.setSpace_state(rs.getBoolean("space_state"));
                space.setServing(rs.getString("serving"));
                response.add(space);
            }
            return response; 
        }
    }
    
    /*public FoodBaseModel foodData(String food_name) throws SQLException{    
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
    }*/
}
