package ProjectOOP.Game.Item;

public abstract class Item  {
    private String ItemName;

    public Item(String Name){
        ItemName = Name;
    }

    public String getItemName(){
        return ItemName;
    }
}
