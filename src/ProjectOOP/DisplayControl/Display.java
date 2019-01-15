package ProjectOOP.DisplayControl;

public class Display {

    static public void printBlackBox(){

        System.out.print(" ");
        DisplayStyle.BackgroundColor.Black();
        System.out.print("   ");
        DisplayStyle.resetAttributes();
        System.out.print(" ");

    }
    static public void printGreenBox(boolean hasPlayer){

        System.out.print(" ");
        DisplayStyle.BackgroundColor.Green();

        if(hasPlayer){
            DisplayStyle.FontStyle.Bold();
            System.out.print(" P ");
        }
        else{
            System.out.print("   ");
        }

        DisplayStyle.resetAttributes();
        System.out.print(" ");

    }

    static public void printGreyBox(boolean hasPlayer){

        System.out.print(" ");
        DisplayStyle.BackgroundColor.Grey();

        if(hasPlayer){
            DisplayStyle.FontStyle.Bold();
            System.out.print(" P ");
        }
        else{
            System.out.print("   ");
        }

        DisplayStyle.resetAttributes();
        System.out.print(" ");;

    }

    static public void printWhiteBox(boolean hasPlayer){

        System.out.print(" ");
        DisplayStyle.resetAttributes();

        if(hasPlayer){
            DisplayStyle.FontStyle.Bold();
            System.out.print(" P ");
        }
        else{
            System.out.print("   ");
        }

        DisplayStyle.resetAttributes();
        System.out.print(" ");

    }

    static public void printLegend(){

        System.out.println("Legend:");

        printWhiteBox(true);
        System.out.print("= Player Location ");

        printGreyBox(false);
        System.out.print("= Door  ");

        printBlackBox();
        System.out.print("= Impassable  ");

        printGreenBox(false);
        System.out.print("= Passable    ");

        System.out.println();

    }

    static public void printPlayerStatus(int Health, int MaxHealth){

        System.out.print("Player Status: |Health: ");

        DisplayStyle.FontColor.Red();
        DisplayStyle.FontStyle.Bold();

        System.out.println(Health + "/" + MaxHealth);

        DisplayStyle.resetAttributes();

    }

    static public void printHelp(){

        System.out.println("Movement: \"w\" = move upwards, \"a\" = move left, \"s\" = move downwards, \"d\" = move right");
        System.out.println("Enter \"q\" to quit game.");
        System.out.println("Enter \"i\" to open Inventory.");
        System.out.println("Use the buttons described above, then press return.");
        System.out.println("On entering multiple buttons the first input will be chosen.");

        Display.printLegend();

    }

    static public void printHelpInfo(){
        System.out.println("For HELP enter h, then enter return");
    }

    static public void clear(){
        for (int i = 0;i<50;++i){
            System.out.println();
        }
    }
}
