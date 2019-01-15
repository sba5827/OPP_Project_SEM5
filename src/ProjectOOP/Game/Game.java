package ProjectOOP.Game;


import ProjectOOP.DisplayControl.Display;
import ProjectOOP.Game.Map.FirstTestMap3x3;
import ProjectOOP.Game.Map.Map;
import ProjectOOP.Input.Input;

public class Game implements WinningConditionListener{

    private Map itsMap;
    private Player itsPlayer;
    private boolean isRunning;

    public Game(){

        itsMap = new FirstTestMap3x3(this);
        itsPlayer = new Player(itsMap.getStartPosition().getX(),itsMap.getStartPosition().getY());
        isRunning = false;

        itsPlayer.addListener(itsMap);

    }

    public void run(){

        isRunning = true;
        String input;

        itsPlayer.decreaseHP(50);

        ShowMainView();

        while (isRunning){

            input = Input.getNextSingleInput();

            ValidateInput(input);

            ShowMainView();

        }
    }

    private void ValidateInput(String input) {

        if(Input.inputIsMoveUp(input)){
            itsPlayer.MoveUp();
        }
        else if(Input.inputIsMoveDown(input)){
            itsPlayer.MoveDown();
        }
        else if(Input.inputIsMoveRight(input)){
            itsPlayer.MoveRight();
        }
        else if(Input.inputIsMoveLeft(input)){
            itsPlayer.MoveLeft();
        }
        else if(Input.inputIsShowHelp(input)){
            ShowHelp();
        }
        else if(Input.inputIsQuit(input)){
            isRunning = false;
        }
        else if(Input.inputIsOpenInventory(input)){

            itsPlayer.getInventory().open();
            ShowMainView();

        }
        else{
            ShowMainView();
        }

    }

    private void ShowMainView(){

        Display.clear();
        Display.printHelpInfo();
        Display.printPlayerStatus(itsPlayer.getHP(),itsPlayer.getMaxHP());
        itsMap.draw(itsPlayer.getPlayerPosition());

    }

    private void ShowHelp(){
        Display.printHelp();
    }

    @Override
    public void onWin() {

        System.out.println("You won the game!");

        isRunning = false;
    }
}
