package ProjectOOP.Game.Item.Equip;

import ProjectOOP.Game.Item.Item;

import java.util.LinkedList;
import java.util.List;

public abstract class EquipableItem extends Item {

    List<EquipableItemListener> Listeners;

    public EquipableItem(String Name){
        super(Name);
        Listeners =new LinkedList<>();
    }

    public void equip() {
        for (EquipableItemListener listener: Listeners
        ) {
            listener.onEquip(this);
        }
    }

    public void unequip() {
        for (EquipableItemListener listener: Listeners
        ) {
            listener.onUnequip(this);
        }
    }

    public void addListener(EquipableItemListener listener) {
        Listeners.add(listener);
    }

    public void removeListener(EquipableItemListener listener) {
        Listeners.remove(listener);
    }
}
