package ProjectOOP.Game.Item.Equip;

import ProjectOOP.Game.Item.Item;

public interface EquipableItemListener {
    void onEquip(Item item);
    void onUnequip(Item item);
}
