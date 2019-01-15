package ProjectOOP.Game.Field;

import ProjectOOP.DisplayControl.Display;

public class ImpassableField extends Field {
    public ImpassableField(){
        super();
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public void draw(int PlayerLocation) {
        Display.printBlackBox();
    }
}
