package ProjectOOP.Game.Item;

public interface Stackable {
    int getStackSize();
    void add(int amount);
    void remove(int amount);
}
