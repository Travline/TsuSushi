package Order;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderBaseModel {
    private int serie;
    private String space_id;
    private String serving;
    private String food;
    private int cant;
    private ArrayList<String> notes = new ArrayList<>();
    private boolean order_state;
    private LocalDateTime created;
    
    public OrderBaseModel(){
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getSpace_id() {
        return space_id;
    }

    public void setSpace_id(String space_id) {
        this.space_id = space_id;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    public boolean isOrder_state() {
        return order_state;
    }

    public void setOrder_state(boolean order_state) {
        this.order_state = order_state;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
