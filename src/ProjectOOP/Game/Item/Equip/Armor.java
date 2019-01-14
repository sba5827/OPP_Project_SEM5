package ProjectOOP.Game.Item.Equip;


public class Armor extends EquipableItem {

    private int defence;

    public Armor(){
        super("Armor");
        this.defence = 10;
    }

    public int getDefence(){
        return this.defence;
    }
}
