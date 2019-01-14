package ProjectOOP.Game.Map;

import ProjectOOP.Game.Field.DoorField;
import ProjectOOP.Game.Field.Field;
import ProjectOOP.Game.Field.ImpassableField;
import ProjectOOP.Game.Field.NormalField;
import ProjectOOP.Game.Item.Useable.HealthPotion;
import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.NPC;

import java.util.LinkedList;
import java.util.List;

public class FirstTestMap3x3 extends Map {
    public FirstTestMap3x3(){
        super();

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
        Line3.add(new NormalField());

        map.add(Line1);
        map.add(Line2);
        map.add(Line3);

        setStartPosition(map.get(0).get(0).getID());
        try{
            setNPC(2,2, new NPC("Bob", "Hello stranger."));
            setItem(2,1,new HealthPotion());
            setItem(0,2,new Key());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
