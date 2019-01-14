package ProjectOOP.Game.Field;

public abstract class PassableField extends Field{

    public PassableField(){
        super();
    }

    @Override
    public boolean isPassable() {
        return true;
    }

}
