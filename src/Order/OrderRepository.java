package Order;

import Core.Database.ConnectionDB;
import java.sql.*;
import Space.SpaceSelected;
import Public.User.UserLoged;
import Public.Menu.FoodSelected;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private SpaceSelected space = SpaceSelected.getInstance();
    private UserLoged user = UserLoged.getInstance();
    private FoodSelected food = FoodSelected.getInstance();
    
    public int getLastSerie() throws SQLException {
        try (Connection conn = new ConnectionDB().connect()) {
            String query = "SELECt serie FROM orders ORDER BY order_id DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                return rs.getInt("serie");
            }
            return 1;
        }
    }
    
    public boolean insertOrder(int cant, ArrayList<String> notes, double price, double total) throws SQLException {
        try (Connection conn = new ConnectionDB().connect()) {
            String query = "INSERT INTO orders(serie, space_id, serving, food, cant, notes, price, total) " +
                       "VALUES (?,?,?,?,?,?,?,?);";
            
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setInt(1, getLastSerie());
            pst.setString(2, space.getSpace_id());
            pst.setString(3, user.getName());
            pst.setString(4, food.getFood_name());
            pst.setInt(5, cant);
            
            Array notesArray = conn.createArrayOf("text", notes.toArray());
            pst.setArray(6, notesArray);

            pst.setDouble(7, price);
            pst.setDouble(8, total);

            pst.executeUpdate();

            return true;
        }  catch (SQLException e) {
        System.err.println("Error al insertar datos: " + e.getMessage());
        throw e; // Re-lanzar la excepción si es necesario
    }
    }
    
    public String[] getOrdersAsHtml() throws SQLException {
    List<String> ordersHtml = new ArrayList<>();
    
    try (Connection conn = new ConnectionDB().connect()) {
        String query = "SELECT serie, space_id, serving, food, cant, notes, total FROM orders;";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            // Obtener los valores de cada fila
            int serie = rs.getInt("serie");
            String space_id = rs.getString("space_id");
            String serving = rs.getString("serving");
            String food = rs.getString("food");
            int cant = rs.getInt("cant");
            Array notesArray = rs.getArray("notes");
            String notes = "";

            // Si el campo 'notes' no es nulo, iteramos sobre las notas para crear un string
            if (notesArray != null) {
                String[] notesList = (String[]) notesArray.getArray();
                for (String note : notesList) {
                    notes += note + "\n"; // Usamos \n para los saltos de línea
                }
            }
            
            double total = rs.getDouble("total");
            
            // Formatear la cadena con saltos de línea para el textarea
            String orderHtml = serie + " Mesa: " + space_id + "\n" +
                               "Mesero: " + serving + "\n" +
                               "[" + cant + "] " + food + "\n" +
                               "Notas:\n" + notes + 
                               "Subtotal: " + total + "\n\n";
            
            // Añadir al arreglo de resultados
            ordersHtml.add(orderHtml);
        }
    }

    // Convertir la lista a un arreglo y devolverlo
    return ordersHtml.toArray(new String[0]);
}


}
