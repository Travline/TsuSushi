package Space;

public class SpaceSelected extends SpaceBaseModel{
    private static SpaceSelected instance;
    
    public SpaceSelected() {
    }

    public static SpaceSelected getInstance() {
        if (instance == null) {
            instance = new SpaceSelected();
        }
        return instance;
    }
}
