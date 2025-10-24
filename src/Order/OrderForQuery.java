package Order;

public class OrderForQuery extends OrderBaseModel{
    private int order_id;
    
    public OrderForQuery(){
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
