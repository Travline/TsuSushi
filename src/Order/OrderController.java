package Order;

import Public.Menu.FoodSelected;
import Public.User.UserLoged;
import Space.SpaceSelected;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderController {
    private OrderRepository orderRepository = new OrderRepository();
    private SpaceSelected spaceSelected = SpaceSelected.getInstance();
    private UserLoged user = UserLoged.getInstance();
    private FoodSelected food = FoodSelected.getInstance();
    
    public String buildNotes(ArrayList<String> notes) {
        StringBuilder buildedNotes = new StringBuilder();
        for (String note : notes) {
            buildedNotes.append(note+"\n");
        }
        return buildedNotes.toString();
    }
    
    public boolean addOrder(String cant, ArrayList<String> notes, String price, String total) throws SQLException{
        try {
            int cantidad = Integer.parseInt(cant);
            double precio = Double.parseDouble(price);
            double tot = Double.parseDouble(total);
            boolean res = orderRepository.insertOrder(cantidad, notes, precio, tot);
            if (res) {
                food.setFood_name("");
                food.setPrice(0.0);
                food.setState(res);
                return true;
            }
            return false;
        } catch (SQLException sqle){
            throw sqle;
        }
    }
    
    public String[] getOrders() throws SQLException{
        return orderRepository.getOrdersAsHtml();
    }
    
    public boolean cleanOrders() throws SQLException{
        return orderRepository.updateOrders();
    }
}
