package ProjectOOP.Game.Field;

import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.Stackable;
import ProjectOOP.Game.NPC.NPC;
import ProjectOOP.Game.Player;
import ProjectOOP.Input.Input;

public class NormalField extends Field {

    private NPC itsNpc;
    private Item itsItem;

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
        return getNpc() != null;
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

    public void OnEnter(Player player) {

        if(this.hasItem()){

            player.getInventory().addItem(this.getItem());
            System.out.print("You found an item: " + this.getItem().getItemName());

            if (this.getItem() instanceof Stackable){
                System.out.print(" amount: " + ((Stackable) this.getItem()).getStackSize());
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

    private void removeItem() {
        setItem(null);
    }
}