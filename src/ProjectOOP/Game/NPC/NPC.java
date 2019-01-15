package ProjectOOP.Game.NPC;

import ProjectOOP.DisplayControl.Display;
import ProjectOOP.DisplayControl.DisplayStyle;
import ProjectOOP.Game.Player;
import ProjectOOP.Input.Input;

import java.util.LinkedList;
import java.util.List;

public class NPC {

    private String Name;
    protected List<String> Sentences = new LinkedList<>();
    protected int talkCounter = 0;

    public NPC(String name, String sentence){

        if(sentence != null && name != null) {

            Name = name;
            addSentence(sentence);

        }
        else {
            throw new NullPointerException();
        }

    }

    public void addSentence(String sentence){
        Sentences.add(sentence);
    }

    public String getName(){
        return Name;
    }

    public void dummySay(){

        DisplayStyle.FontColor.Red();
        System.out.println("My name is " + getName());
        DisplayStyle.resetAttributes();

    }

    protected void talk(Player player){

        Display.clear();

        System.out.println(getName() + ": ");

        DisplayStyle.FontColor.Red();
        System.out.print("\t");
        System.out.println(Sentences.get(talkCounter));
        DisplayStyle.resetAttributes();

        if(talkCounter < Sentences.size()-1) {
            talkCounter++;
        }

        System.out.println("Press enter to continue...");
        Input.getNextInput();

    }

    public void onEncounter(Player player){
        dialog(player);
    }

    private void dialog(Player player){

        boolean close = false;

        while (!close){

            Display.clear();

            System.out.println("You encountered " + getName() + ". What will you do?");
            System.out.println("\t1. talk");
            System.out.println("\t2. leave");

            boolean validInput = false;

            while (!validInput) {

                String input = Input.getNextInput();

                if (Input.inputIsSingleDigitNumber(input)) {

                    switch (Integer.valueOf(input)) {

                        case 1:

                            talk(player);
                            validInput = true;
                            break;

                        case 2:

                            validInput = true;
                            close = true;
                            break;

                        default:

                            System.out.println("Invalid input.");
                            break;

                    }
                }
                else {
                    System.out.println("Invalid input.");
                }
            }

        }
    }
}

