package ProjectOOP.Game.Map;


import ProjectOOP.DisplayControl.Display;
import ProjectOOP.Game.Field.DoorField;
import ProjectOOP.Game.Field.Field;
import ProjectOOP.Game.Field.NormalField;
import ProjectOOP.Game.Item.Item;
import ProjectOOP.Game.Item.Useable.Key;
import ProjectOOP.Game.NPC.NPC;
import ProjectOOP.Game.Player;

import java.util.LinkedList;
import java.util.List;

public abstract class Map {

    protected List<List<Field>> map;
    private int startPosition;

    public Map(){
        map = new LinkedList<>();
    }

    protected void setStartPosition(int FieldID_StartPosition){
        startPosition = FieldID_StartPosition;
    }

    public void draw(int FieldID_PlayerLocation){
        for (List<Field> Line: map
             ) {
            for (Field field: Line
                 ) {

                boolean isPlayerLocation = (field.getID() == FieldID_PlayerLocation);

                if(field instanceof NormalField){
                    Display.printGreenBox(isPlayerLocation);
                }
                else if(field instanceof DoorField){
                    Display.printGreyBox(isPlayerLocation);
                }
                else{
                    Display.printBlackBox();
                }
            }
            Display.newLine();
        }
    }

    public int getStartPosition() {
        return startPosition;
    }

    private Field getFieldUp(int referenceFieldID) throws Exception {

        List<Field> prevLine = null;
        Field requestedField;

        for (List<Field>Line:map
        ) {
            for (Field field:Line
            ) {
                if(field.getID() == referenceFieldID){
                    if(prevLine == null){
                        System.out.println("Requested field out of bound");
                        return null;
                    }

                    requestedField = prevLine.get(Line.indexOf(field));

                    return requestedField;
                }
            }
            prevLine = Line;
        }

        throw new Exception();
    }

    private Field getFieldDown(int referenceFieldID) throws Exception {

        List<Field> nextLine;
        Field requestedField;

        for (List<Field>Line:map
        ) {
            try {
                nextLine = map.get(map.indexOf(Line) + 1);
            }
            catch (Exception e){
                System.out.println("Requested field out of bound");
                return null;
            }


            for (Field field:Line
            ) {
                if(field.getID() == referenceFieldID){
                    if(nextLine == null){
                        return null;
                    }

                    requestedField = nextLine.get(Line.indexOf(field));

                    return requestedField;
                }
            }
        }

        throw new Exception();
    }

    private Field getFieldRight(int referenceFieldID) throws Exception {

        Field requestedField;

        for (List<Field>Line:map
        ) {
            for (Field field:Line
            ) {
                if(field.getID() == referenceFieldID){

                    try {
                        requestedField = Line.get(Line.indexOf(field) + 1);
                        return requestedField;
                    }
                    catch (Exception e){
                        System.out.println("Requested field out of bound");
                        return null;
                    }
                }
            }
        }

        throw new Exception();
    }

    private Field getFieldLeft(int referenceFieldID) throws Exception {

        Field requestedField;

        for (List<Field>Line:map
        ) {
            for (Field field:Line
            ) {
                if(field.getID() == referenceFieldID){

                    try {
                        requestedField = Line.get(Line.indexOf(field) - 1);
                        return requestedField;
                    }
                    catch (Exception e){
                        System.out.println("Requested field out of bound");
                        return null;
                    }
                }
            }
        }

        throw new Exception();
    }

    private Field getField(int fieldID) throws Exception {
        Field requestedField;

        for (List<Field>Line:map
        ) {
            for (Field field:Line
            ) {
                if(field.getID() == fieldID){

                    try {
                        requestedField = Line.get(Line.indexOf(field));
                        return requestedField;
                    }
                    catch (Exception e){
                        System.out.println("Requested field out of bound");
                        return null;
                    }
                }
            }
        }

        throw new Exception();
    }

    public int getNewPosition(Player player, String direction) {

        Field requestedField;

        direction = direction.toLowerCase();

        try {
            switch (direction) {
                case "left":
                    requestedField = getFieldLeft(player.getPlayerPosition());
                    break;
                case "right":
                    requestedField = getFieldRight(player.getPlayerPosition());
                    break;
                case "up":
                    requestedField = getFieldUp(player.getPlayerPosition());
                    break;
                case "down":
                    requestedField = getFieldDown(player.getPlayerPosition());
                    break;
                default:
                    throw new Exception("No such direction");
            }
        }
        catch (Exception e){
            return player.getPlayerPosition();
        }
        if(requestedField == null){
            return player.getPlayerPosition();
        }
        if(requestedField.isPassable()){
            return requestedField.getID();
        }
        else{
            if(requestedField instanceof DoorField){

                int ItemIndex = player.getInventory().InventoryHasInstanceOf(new Key());

                if(ItemIndex != -1){

                    Key key = (Key)player.getInventory().getItem(ItemIndex);
                    ((DoorField) requestedField).unlock(key);

                    return requestedField.getID();

                }
                else{
                    System.out.println("You got no key to open the door.");
                }

            }
            return player.getPlayerPosition();
        }
    }

    public void setNPC(int x, int y, NPC npc) throws Exception {

        if(map.get(y).get(x) instanceof NormalField){
            ((NormalField)map.get(y).get(x)).setNpc(npc);
        }
        else{
            throw new Exception("NPC cant be placed on this Field");
        }

    }

    public void setItem(int x, int y, Item item) throws Exception {

        if(map.get(y).get(x) instanceof NormalField){
            ((NormalField)map.get(y).get(x)).setItem(item);
        }
        else{
            throw new Exception("Item cant be placed on this Field");
        }

    }

    public void enterField(Player player) throws Exception {

        Field field = getField(player.getPlayerPosition());

        if(field instanceof NormalField){
            ((NormalField) field).OnEnter(player);
        }
    }
}
