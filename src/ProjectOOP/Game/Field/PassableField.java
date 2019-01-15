package ProjectOOP.Game.Field;

import ProjectOOP.Game.Player;

public abstract class PassableField extends Field{

    public PassableField(){
        super();
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    public abstract void OnEnter(Player player);

}
