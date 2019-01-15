package ProjectOOP.Game;

import ProjectOOP.Game.Item.Equip.Armor;
import ProjectOOP.Game.Item.Equip.Weapon;
import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.Useable.HealthPotion;
import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.Item.Useable.UseableItem;
import ProjectOOP.Input.Input;

import java.util.LinkedList;
import java.util.List;

public class Player extends InventoryOwner{

    private static final int MaxHP = 100;

    //Intern Variables
    List<PositionListener> listeners = new LinkedList<>();

    private int HP;
    private Armor armor;
    private Weapon weapon;

    private XY_Position position;
    private XY_Position positionOld;

    public Player(int startPositionX, int startPositionY){

        super();

        setHP(MaxHP);
        setArmor(null);
        setWeapon(null);

        position = new XY_Position(startPositionX,startPositionY);
        positionOld = new XY_Position(startPositionX,startPositionY);

    }

    private void setHP(int HP){
        this.HP = HP;
    }
    private void setArmor(Armor armor){
        this.armor = armor;
    }
    private void setWeapon(Weapon weapon) {
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

    public final XY_Position getPlayerPosition(){
        return position;
    }

    public void MoveUp(){

        backupPosition();
        position.setY(position.getY()-1);
        notifyListeners();

    }
    public void MoveDown(){

        backupPosition();
        position.setY(position.getY()+1);
        notifyListeners();

    }
    public void MoveRight(){

        backupPosition();
        position.setX(position.getX()+1);
        notifyListeners();

    }
    public void MoveLeft(){

        backupPosition();
        position.setX(position.getX()-1);
        notifyListeners();

    }

    public void addListener(PositionListener listener){
        listeners.add(listener);
    }
    public void removeListener(PositionListener listener){
        listeners.remove(listener);
    }

    private void notifyListeners(){

        for (PositionListener listener:listeners) {
            listener.onPositionChanged(this);
        }

    }

    private void backupPosition(){

        positionOld.setX(position.getX());
        positionOld.setY(position.getY());

    }

    public void restorePosition(){

        position.setX(positionOld.getX());
        position.setY(positionOld.getY());

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

        if((item).getStackSize() < 2) {

            try {
                getInventory().removeItem(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            (item).remove(1);
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
