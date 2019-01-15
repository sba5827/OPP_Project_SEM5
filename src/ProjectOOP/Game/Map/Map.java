package ProjectOOP.Game.Map;


import ProjectOOP.Game.Field.DoorField;
import ProjectOOP.Game.Field.Field;
import ProjectOOP.Game.Field.NormalField;
import ProjectOOP.Game.Field.PassableField;
import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.NPC.NPC;
import ProjectOOP.Game.Player;
import ProjectOOP.Game.PositionListener;
import ProjectOOP.Game.XY_Position;

import java.util.LinkedList;
import java.util.List;

public abstract class Map implements PositionListener {

    protected List<List<Field>> map;
    private XY_Position startingPosition;

    public Map(){

        map = new LinkedList<>();
        startingPosition = new XY_Position(0,0);

    }

    public void draw(XY_Position playerPosition){


        int y = 0;

        for (List<Field> Line: map){

            int x = 0;

            for (Field field: Line) {

                if(playerPosition.equals(x,y)){
                    field.draw(true);
                }
                else{
                    field.draw(false);
                }

                x++;

            }

            y++;

            System.out.println();

        }

    }
    public XY_Position getStartPosition() {
        return startingPosition;
    }

    protected void setNPC(int x, int y, NPC npc) throws Exception {

        if(map.get(y).get(x) instanceof NormalField){
            ((NormalField)map.get(y).get(x)).setNpc(npc);
        }
        else{
            throw new Exception("NPC cant be placed on this Field");
        }

    }
    protected void setItem(int x, int y, Item item) throws Exception {

        if(map.get(y).get(x) instanceof NormalField){
            ((NormalField)map.get(y).get(x)).setItem(item);
        }
        else{
            throw new Exception("Item cant be placed on this Field");
        }

    }

    protected void setStartPosition(int x, int y){

        startingPosition.setX(x);
        startingPosition.setY(y);

    }

    @Override
    public void onPositionChanged(Player player) {

        Field newField;

        try{
            newField = map.get(player.getPlayerPosition().getY()).get(player.getPlayerPosition().getX());

            if(newField.isPassable()){
                ((PassableField)newField).OnEnter(player);
            }
            else if(newField instanceof DoorField){

                int index = player.getInventory().getIndexOfInstanceOf(new Key());

                if(index  != -1){

                    ((DoorField) newField).unlock((Key)player.getInventory().getItem(index));
                    ((DoorField) newField).OnEnter(player);

                }
                else {
                    player.restorePosition();
                }
            }
            else{
                player.restorePosition();
            }
        }
        catch (Exception e){
            player.restorePosition();
        }

    }
}
