package Space;

public class SpaceBaseModel {
    private String space_id;
    private boolean space_state;
    private String serving;

    public SpaceBaseModel() {
    }

    public String getSpace_id() {
        return space_id;
    }

    public void setSpace_id(String space_id) {
        this.space_id = space_id;
    }

    public boolean isSpace_state() {
        return space_state;
    }

    public void setSpace_state(boolean space_state) {
        this.space_state = space_state;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    } 
}
