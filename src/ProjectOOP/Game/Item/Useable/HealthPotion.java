package ProjectOOP.Game.Item.Useable;

public class HealthPotion extends UseableItem {

    private static final int restoreValue = 20;

    public HealthPotion(int stackSize){
        super("Potion",stackSize);
    }

    public HealthPotion(){
        super("Potion",1);
    }

    public int getRestoreValue(){
        return restoreValue;
    }



}
