package Space;

import Public.User.UserLoged;
import java.util.ArrayList;
import java.sql.*;

public class SpaceController {
    public ArrayList<SpaceBaseModel> spacesData() throws SQLException {
        SpaceRepository repo = new SpaceRepository();
        var data = repo.spaceListData();
        if (data != null) {
            return data;
        }
        return null;
    }
    
    public boolean selectSpace(SpaceBaseModel space) {
        SpaceSelected spaceSelected = SpaceSelected.getInstance();
        UserLoged userLoged = UserLoged.getInstance();
        if (space.isSpace_state() == true && !(space.getServing() == userLoged.getName())) {
            return false;
        }
        spaceSelected.setSpace_id(space.getSpace_id());
        spaceSelected.setSpace_state(space.isSpace_state());
        spaceSelected.setServing(space.getServing());
        return true;
    }
}
