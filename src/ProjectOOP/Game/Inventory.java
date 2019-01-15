package ProjectOOP.Game;

import ProjectOOP.DisplayControl.Display;
import ProjectOOP.Game.Item.Equip.EquipableItem;
import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.Stackable;
import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.Item.Useable.UseableItem;
import ProjectOOP.Input.Input;

import java.util.LinkedList;
import java.util.List;

public class Inventory{

    private List<Item> inventory;
    private InventoryOwner owner;

    Inventory(InventoryOwner owner) throws NullPointerException {
        inventory = new LinkedList<>();
        if(owner != null) {
            this.owner = owner;
        }
        else{
            throw new NullPointerException();
        }
    }

    public int InventoryHasInstanceOf(Item obj) {
        for (Item item:inventory) {
            if(item.getClass().getName().contentEquals(obj.getClass().getName())){
                return inventory.indexOf(item);
            }
        }
        return -1;
    }

    public void addItem(Item item){
        int Index = InventoryHasInstanceOf(item);

        if(Index != -1){
            if(item instanceof Stackable){
                ((Stackable)inventory.get(Index)).add(((Stackable) item).getStackSize());
            }
            else{
                inventory.add(item);
                if(item instanceof UseableItem){
                    ((UseableItem)item).addListener(owner);
                }
                else if( item instanceof EquipableItem){
                    ((EquipableItem)item).addListener(owner);
                }
            }
        }
        else{
            inventory.add(item);
            if(item instanceof UseableItem){
                ((UseableItem)item).addListener(owner);
            }
            else if( item instanceof EquipableItem){
                ((EquipableItem)item).addListener(owner);
            }
        }

    }
    public void removeItem(Item item) throws Exception {

        if(inventory.contains(item)){

            int Index = inventory.indexOf(item);

            if(item instanceof Stackable){
                ((UseableItem)item).removeListener(owner);
            }
            else if(item instanceof EquipableItem){
                ((EquipableItem)item).removeListener(owner);
            }

            inventory.remove(item);
        }
        else{
            throw new Exception("Item not valid. @PKG_Game.Player.removeItem");
        }
    }

    public final Item getItem(int index){
        return inventory.get(index);
    }

    private void show(){

        System.out.println("\tItem:\tAmount:");

        int count = 0;

        for (Item item:inventory
             ) {
            count++;
            System.out.print(count+":\t");
            System.out.print(item.getItemName()+"\t");
            if(item instanceof Stackable){
                System.out.print("x" + ((Stackable)item).getStackSize());
            }
            Display.newLine();
        }
    }

    private void showItemOption(Item selectedItem){

        if(selectedItem instanceof UseableItem){

            System.out.println("1. use");
            System.out.println("2. dump");
            System.out.println("3. back");

        }
        else if(selectedItem instanceof EquipableItem){

            System.out.println("1. equip");
            System.out.println("2. dump");
            System.out.println("3. back");

        }
    }

    private void executeSelectedItemOption(int option, Item selectedItem) throws Exception{

        switch (option){

            case 1:
                if(selectedItem instanceof Key){
                    System.out.println("Will be used if you try to enter a Door.\n prss enter to continue...");
                    Input.getNextInput();
                }
                else if(selectedItem instanceof UseableItem){
                    ((UseableItem) selectedItem).use();
                }
                else if(selectedItem instanceof EquipableItem){
                    ((EquipableItem) selectedItem).equip();
                }
                break;

            case 2:
                if(selectedItem instanceof Key){
                    System.out.println("You better keep it...\n prss enter to continue...");
                    Input.getNextInput();
                    return;
                }

                try{
                    removeItem(selectedItem);
                }
                catch (Exception e){

                    e.printStackTrace();

                }
                break;

            default:
                throw new Exception("No such Option");
        }
    }

    public void open(){

        boolean close = false;

        Item SelectedItem;

        while(!close){
            Display.clear();
            show();
            System.out.println("Select Item by entering its number. Enter \"I\" to close Inventory");
            String input = Input.getNextInput();

            if(input.charAt(0) == 'i'||input.charAt(0) == 'I'){
                close = true;
            }else{
                try{
                    SelectedItem = getItem(Input.toPositiveNumber(input)-1);
                    openOptionDialog(SelectedItem);
                }
                catch (Exception e){
                    System.out.println("Input is not valid");
                }
            }


        }

    }

    private void openOptionDialog(Item item){

        boolean close = false;

        Display.clear();
        showItemOption(item);

        while (!close) {

            String input = Input.getNextSingleInput();

            if(Input.inputIsSingleDigitNumber(input)){
                try {
                    switch (Integer.valueOf(input)) {
                        case 1:
                            executeSelectedItemOption(1, item);
                            close = true;
                            break;
                        case 2:
                            executeSelectedItemOption(2, item);
                            close = true;
                            break;
                        case 3:
                            close = true;
                            break;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                }
                catch (Exception e){
                    throw new Error("ItemOptionDialog Error");
                }
            }
            else {
                System.out.println("Invalid input.");
            }

        }
    }
}
