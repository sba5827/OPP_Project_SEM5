package ProjectOOP.Game.Field;

public class ImpassableField extends Field {
    public ImpassableField(){
        super();
    }

    @Override
    public boolean isPassable() {
        return false;
    }
}
