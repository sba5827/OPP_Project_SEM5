package ProjectOOP.Game.Field;

import ProjectOOP.DisplayControl.Display;
import ProjectOOP.Game.Player;
import ProjectOOP.Game.WinningConditionListener;

public class WinningField extends PassableField {

    WinningConditionListener listener;

    public WinningField(WinningConditionListener listener){

        super();
        this.listener = listener;

    }

    @Override
    public void OnEnter(Player player) {
        listener.onWin();
    }

    @Override
    public void draw(int PlayerLocation) {
        Display.printGreenBox(getID() == PlayerLocation);
    }

}
