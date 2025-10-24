package Public.Menu;

import java.sql.*;
import java.util.HashSet;

public class FoodController {
    public HashSet<String> searchFood(String searchingFood) throws SQLException {
        FoodRepository foodRepository = new FoodRepository();
        var data = foodRepository.foodList();
        if (!(data == null) || !data.isEmpty()) {
            return data;
        }
        return null;
    }
    
    public void setFoodSelected(String food) throws SQLException{
        FoodRepository foodRepository = new FoodRepository();
        var data = foodRepository.foodData(food);
        if (!(data == null)) {
            FoodSelected foodSelected = FoodSelected.getInstance();
            foodSelected.setFood_name(food);
            foodSelected.setInfo(data.getInfo());
            foodSelected.setPrice(data.getPrice());
            foodSelected.setCategory(data.getCategory());
            foodSelected.setCreated(data.getCreated());
            foodSelected.setState(true);
        }
    }
}
