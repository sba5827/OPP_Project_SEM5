package ProjectOOP.Game.Item.Equip;


public class Weapon extends EquipableItem {

    private int attack;

    public Weapon(){
        super("Weapon");
        this.attack = 3;
    }

    public int getAttack(){
        return this.attack;
    }

}
