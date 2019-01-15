package ProjectOOP.Game.NPC;

import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Player;

public class NPC_Gift extends NPC{

    private Item Gift;

    public NPC_Gift(String name, String sentence, Item gift) {

        super(name, sentence);

        if(gift == null){
            throw new NullPointerException();
        }

        this.Gift = gift;

    }

    @Override
    protected void talk(Player player){

        super.talk(player);

        if(Sentences.size()-1 == talkCounter && Gift != null){

            player.getInventory().addItem(Gift);

            Gift = null;

        }

    }


}
