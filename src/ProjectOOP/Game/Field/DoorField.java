package ProjectOOP.Game.Field;

import ProjectOOP.Game.Item.Useable.Key;

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

    public void unlock(Key key){
        key.use();
        this.locked = false;
    }
}
