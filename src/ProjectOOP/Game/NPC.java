package ProjectOOP.Game;

import ProjectOOP.DisplayControl.Display;
import ProjectOOP.DisplayControl.DisplayStyle;

public class NPC {

    String Name;

    public NPC(String name){
        Name = name;
    }

    public String getName(){
        return Name;
    }

    public void dummySay(){
        DisplayStyle.FontColor.Red();
        System.out.println("My name is " + getName());
        DisplayStyle.resetAttributes();
    }

}
