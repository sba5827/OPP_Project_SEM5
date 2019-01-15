package ProjectOOP.Game.Item.Useable;

import ProjectOOP.Game.Item.StackableItem;

import java.util.LinkedList;
import java.util.List;

public abstract class UseableItem extends StackableItem {

    private List<UseableItemListener> Listeners;

    public UseableItem(String Name, int stackSize){

        super(Name, stackSize);
        Listeners = new LinkedList<>();

    }

    public void use() {

        for (UseableItemListener listener:Listeners) {
            listener.onUse(this);
        }

    }

    public void addListener(UseableItemListener listener) {
        Listeners.add(listener);
    }

    public void removeListener(UseableItemListener listener) {
        Listeners.remove(listener);
    }
}
