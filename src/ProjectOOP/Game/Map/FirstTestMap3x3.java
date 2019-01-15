package ProjectOOP.Game.Map;

import ProjectOOP.Game.Field.*;
import ProjectOOP.Game.Item.Equip.Weapon;
import ProjectOOP.Game.Item.Useable.HealthPotion;
import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.NPC.NPC;
import ProjectOOP.Game.NPC.NPC_Gift;
import ProjectOOP.Game.WinningConditionListener;

import java.util.LinkedList;
import java.util.List;

public class FirstTestMap3x3 extends Map {

    public FirstTestMap3x3(WinningConditionListener wcListener){

        List<Field> Line1 = new LinkedList<>();
        List<Field> Line2 = new LinkedList<>();
        List<Field> Line3 = new LinkedList<>();

        Line1.add(new NormalField());
        Line1.add(new NormalField());
        Line1.add(new DoorField());

        Line2.add(new NormalField());
        Line2.add(new ImpassableField());
        Line2.add(new NormalField());

        Line3.add(new NormalField());
        Line3.add(new ImpassableField());
        Line3.add(new WinningField(wcListener));

        map.add(Line1);
        map.add(Line2);
        map.add(Line3);

        setStartPosition(0,0);

        NPC Bob = new NPC_Gift("Bob", "Hello stranger.",new Weapon());
        Bob.addSentence("Take this, you'll need it");

        try{
            setNPC(2,1, Bob);
            setItem(2,1,new HealthPotion(3));
            setItem(0,2,new Key());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
