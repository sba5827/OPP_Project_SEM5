package ProjectOOP.Game.Field;

import ProjectOOP.DisplayControl.Display;
import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.StackableItem;
import ProjectOOP.Game.NPC.NPC;
import ProjectOOP.Game.Player;
import ProjectOOP.Input.Input;

public class NormalField extends PassableField {

    private NPC itsNpc;
    private Item itsItem;

    public NormalField() {
        super();
        setNpc(null);
    }

    public NormalField(NPC npc) {

        super();
        setNpc(npc);

    }

    public NPC getNpc() {
        return itsNpc;
    }
    public void setNpc(NPC npc) {
        this.itsNpc = npc;
    }

    public Item getItem() {
        return itsItem;
    }
    public void setItem(Item itsItem) {
        this.itsItem = itsItem;
    }

    public boolean hasItem(){
        return getItem() != null;
    }
    public boolean hasNPC() {
        return getNpc() != null;
    }

    public void removeItem() {
        setItem(null);
    }
    public void removeNPC() {
        setNpc(null);
    }

    @Override
    public void OnEnter(Player player) {

        if(this.hasItem()){

            player.getInventory().addItem(this.getItem());
            System.out.print("You found an item: " + this.getItem().getItemName());

            if (this.getItem() instanceof StackableItem){
                System.out.print(" amount: " + ((StackableItem) this.getItem()).getStackSize());
            }

            System.out.println(".");
            this.removeItem();

            System.out.println("Press enter to continue...");
            Input.getNextInput();

        }

        if (this.hasNPC()) {
            this.getNpc().onEncounter(player);
        }

    }

    @Override
    public void draw(int PlayerLocation) {
        Display.printGreenBox(getID() == PlayerLocation);
    }
}