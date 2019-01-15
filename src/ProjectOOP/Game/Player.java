package ProjectOOP.Game;

import ProjectOOP.Game.Item.Equip.Armor;
import ProjectOOP.Game.Item.Equip.Weapon;
import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.Stackable;
import ProjectOOP.Game.Item.Useable.HealthPotion;
import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.Item.Useable.UseableItem;
import ProjectOOP.Game.Map.Map;
import ProjectOOP.Input.Input;

public class Player extends InventoryOwner{

    private static final int MaxHP = 100;

    //Intern Variables
    private int HP;
    private Armor armor;
    private Weapon weapon;

    private int PlayerPosition_byFieldId;

    public Player(int startPosition){

        super();

        setHP(MaxHP);
        setArmor(null);
        setWeapon(null);

        setPlayerPosition(startPosition);

    }

    private void setHP(int HP){
        this.HP = HP;
    }



    public void setArmor(Armor armor){
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHP() {
        return HP;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }



    public void increaseHP(int hp){
        if(getHP()+ hp < MaxHP) {

            setHP(getHP() + hp);
            System.out.println("You restore " + hp +"HP.\nPress enter to continue...");
            Input.getNextInput();

        }
        else{

            System.out.println("You restore " + (MaxHP - getHP())  + "HP.\nPress enter to continue...");
            setHP(MaxHP);
            Input.getNextInput();

        }
    }

    public void decreaseHP(int hp){
        if(getHP()- hp > 0) {
            setHP(getHP() - hp);
        }
        else{
            setHP(0);
        }
    }

    public int getPlayerPosition(){
        return PlayerPosition_byFieldId;
    }

    private void setPlayerPosition(int position){
        PlayerPosition_byFieldId = position;
    }

    public void MoveUp(Map map){

        setPlayerPosition(map.getNewPosition(this,"up"));

    }
    public void MoveDown(Map map){

        setPlayerPosition(map.getNewPosition(this,"down"));

    }
    public void MoveRight(Map map){

        setPlayerPosition(map.getNewPosition(this,"right"));

    }
    public void MoveLeft(Map map){

        setPlayerPosition(map.getNewPosition(this,"left"));

    }

    //Interface UseableItemListener
    @Override
    public void onUse(UseableItem item) {
        if(item instanceof HealthPotion){
            this.increaseHP(((HealthPotion) item).getRestoreValue());
        }
        else if(item instanceof Key){
            System.out.println("You used a Key to unlock the door.\nPress enter to continue...");
            Input.getNextInput();
        }

        if(((Stackable)item).getStackSize() < 2) {

            try {
                getInventory().removeItem(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            ((Stackable)item).remove(1);
        }

    }

    // Interface EquipableItemListener
    @Override
    public void onEquip(Item item) {
        if(item instanceof Armor){
            if(getArmor() != null){
                getInventory().addItem(getArmor());
            }
            setArmor((Armor) item);
        }
        else if(item instanceof Weapon){
            if(getWeapon() != null){
                getInventory().addItem(getWeapon());
            }
            setWeapon((Weapon)item);
        }
        try{
            getInventory().removeItem(item);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUnequip(Item item) {
        if(item instanceof Armor){
            if(item.equals(getArmor())){
                getInventory().addItem(item);
                setArmor(null);
            }
        }
        else if(item instanceof Weapon){
            if(item.equals(getWeapon())){
                getInventory().addItem(item);
                setWeapon(null);
            }
        }
    }
}
