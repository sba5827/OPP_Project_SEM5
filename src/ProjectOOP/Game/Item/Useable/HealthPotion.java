package ProjectOOP.Game.Item.Useable;

import ProjectOOP.Game.Item.Stackable;

public class HealthPotion extends UseableItem implements Stackable {

    private int stackSize;

    private static final int restoreValue = 20;

    public HealthPotion(){
        super("Potion");
        stackSize = 1;
    }

    public int getRestoreValue(){
        return restoreValue;
    }

    @Override
    public int getStackSize() {
        return stackSize;
    }

    @Override
    public void add(int amount) {
        stackSize = stackSize+amount;
    }

    @Override
    public void remove(int amount) {
        stackSize = stackSize-amount;
    }

}
