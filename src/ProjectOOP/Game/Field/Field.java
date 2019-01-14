package ProjectOOP.Game.Field;

public abstract class Field {

    private static int FieldCount = 0;
    private final int ID;


    public Field(){
        ID = ++FieldCount;
    }

    public abstract boolean isPassable();

    public int getID(){
        return ID;
    }

}
