package ProjectOOP.Game.Field;

import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.Stackable;
import ProjectOOP.Game.NPC;
import ProjectOOP.Game.Player;

public class NormalField extends Field {

    NPC itsNpc;
    Item itsItem;

    public NormalField() {
        super();
        setNpc(null);
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    public NPC getNpc() {
        return itsNpc;
    }

    public void setNpc(NPC npc) {
        this.itsNpc = npc;
    }

    public NPC removeNPC() {
        NPC buffer = getNpc();
        setNpc(null);
        return buffer;
    }

    public boolean hasNPC() {
        if (getNpc() != null) {
            return true;
        }
        return false;
    }

    public Item getItem() {
        return itsItem;
    }

    public void setItem(Item itsItem) {
        this.itsItem = itsItem;
    }

    public boolean hasItem(){
        if(getItem() != null){
            return true;
        }
        return false;
    }

    public void OnEnter(Player player) {

        if(this.hasItem()){
            player.getInventory().addItem(this.getItem());
            System.out.print("You found an item: " + this.getItem().getItemName());
            if (this.getItem() instanceof Stackable){
                System.out.print(" amount: " + ((Stackable) this.getItem()).getStackSize());
            }
            System.out.println(".");
            this.removeItem();
        }

        if (this.hasNPC()) {
            System.out.println("You encountered an NPC. He talks to you: ");
            this.getNpc().dummySay();
        }
    }

    private Item removeItem() {
        Item buffer = getItem();
        setItem(null);
        return buffer;
    }
}