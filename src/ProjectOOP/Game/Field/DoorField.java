package ProjectOOP.Game.Field;

import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.Player;

public class DoorField extends PassableField {

    private boolean locked;

    public DoorField(){
        super();
        this.locked = true;
    }

    public boolean isLocked(){
        return locked;
    }

    @Override
    public boolean isPassable(){
        return !isLocked();
    }

    @Override
    public void OnEnter(Player player) {

    }

    public void unlock(Key key){
        key.use();
        this.locked = false;
    }
}
