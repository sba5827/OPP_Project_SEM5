package ProjectOOP.Game;

import ProjectOOP.Game.Item.Equip.EquipableItemListener;
import ProjectOOP.Game.Item.Useable.UseableItemListener;

public abstract class InventoryOwner implements UseableItemListener, EquipableItemListener {

    private Inventory itsInventory;

    public InventoryOwner(){
        itsInventory = new Inventory(this);
    }

    public Inventory getInventory(){
        return itsInventory;
    }
}
