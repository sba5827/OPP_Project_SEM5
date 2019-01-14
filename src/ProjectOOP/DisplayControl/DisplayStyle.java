package ProjectOOP.DisplayControl;

public class DisplayStyle {
    static public void resetAttributes(){
        System.out.print("\033[0m");
    }
    static public class BackgroundColor{
        static public void Red(){
            System.out.print("\033[41m");
        }
        static public void Green(){
            System.out.print("\033[42m");
        }
        static public void Black(){
            System.out.print("\033[40m");
        }
        static public void Grey(){
            System.out.print("\033[47m");
        }
        static public void Yellow(){
            System.out.print("\033[43m");
        }
        static public void Blue(){
            System.out.print("\033[44m");
        }
    }
    static public class FontColor{
        static public void Black(){
            System.out.print("\033[30m");
        }
        static public void Red(){
            System.out.print("\033[31m");
        }
        static public void Yellow(){
            System.out.print("\033[32m");
        }
        static public void Blue(){
            System.out.print("\033[33m");
        }
        static public void White(){
            System.out.print("\033[37m");
        }
    }
    static public class FontStyle{
        static public void Bold(){
            System.out.print("\033[1m");
        }
        static public void Underlined(){
            System.out.print("\033[4m");
        }
        static public void Blinking(){
            System.out.print("\033[5m");
        }
    }
}
