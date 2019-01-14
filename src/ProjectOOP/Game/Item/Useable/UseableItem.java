package ProjectOOP.Game.Item.Useable;

import ProjectOOP.Game.Item.Item;

import java.util.LinkedList;
import java.util.List;

public abstract class UseableItem extends Item {

    private List<UseableItemListener> Listeners;

    public UseableItem(String Name){

        super(Name);
        Listeners = new LinkedList<UseableItemListener>();

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
