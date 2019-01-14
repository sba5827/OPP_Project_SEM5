package ProjectOOP.Game.Item.Useable;

import ProjectOOP.Game.Item.Stackable;
import ProjectOOP.Game.Item.Useable.UseableItem;

public class Key extends UseableItem implements Stackable {

    int stackSize;

    public Key(){
        super("Key");
        stackSize = 1;
    }

    @Override
    public int getStackSize() {
        return stackSize;
    }

    @Override
    public void add(int amount) {
        stackSize = stackSize + amount;
    }

    @Override
    public void remove(int amount) {
        stackSize = stackSize - amount;
    }

}
