package ProjectOOP.Game.Item;

public abstract class StackableItem extends Item{

    private int stackSize;

    public StackableItem(String Name, int stackSize) {

        super(Name);
        this.stackSize = stackSize;

    }

    public int getStackSize() {
        return stackSize;
    }
    public void add(int amount) {
        stackSize = stackSize+amount;
    }
    public void remove(int amount) {
        stackSize = stackSize-amount;
    }

}
