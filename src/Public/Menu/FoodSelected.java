package Public.Menu;

import java.util.List;
import java.util.ArrayList;

public class FoodSelected extends FoodBaseModel{
    private static FoodSelected instance;
    private boolean state = false;
    private final List<FoodSelectedObserver> observers = new ArrayList<>();
    
    private FoodSelected() {
        
    }

    public static FoodSelected getInstance() {
        if (instance == null) {
            instance = new FoodSelected();
        }
        return instance;
    }

    public void addObserver(FoodSelectedObserver o) {
        observers.add(o);
    }
    
    public void notifyObservers(boolean newState) {
        for (FoodSelectedObserver o : observers) {
            o.foodSelectedStateListener(newState);
        }
    }
    
    public void setState(boolean state) {
        this.state = state;
        notifyObservers(state);
    }
    
    public boolean isState() {
        return state;
    }    
}
