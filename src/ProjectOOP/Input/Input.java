package ProjectOOP.Input;

import javax.print.DocFlavor;
import java.io.IOException;

public class Input {
    static public String getNextSingleInput(){
        char Input = 0;
        char Dump;

        try {
            Input = (char)System.in.read();
            while(0 != System.in.available()){
                Dump = (char)System.in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(Input);
    }

    static public String getNextInput(){
        char nextChar = 0;
        StringBuilder Input = new StringBuilder();

        try {
            nextChar = (char)System.in.read();
            while(0 != System.in.available()){
                Input.append(String.valueOf(nextChar));
                nextChar = (char)System.in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return Input.toString();
    }

    static public int toPositiveNumber(String input) throws Exception {

        int limit = input.length();
        int value = 0;
        int returnValue = 0;

        for (int i = 0; i < limit;++i){
            switch (input.charAt(i)){
                case '0':
                    value = 0;
                    break;
                case '1':
                    value = 1;
                    break;
                case '2':
                    value = 2;
                    break;
                case '3':
                    value = 3;
                    break;
                case '4':
                    value = 4;
                    break;
                case '5':
                    value = 5;
                    break;
                case '6':
                    value = 6;
                    break;
                case '7':
                    value = 7;
                    break;
                case '8':
                    value = 8;
                    break;
                case '9':
                    value = 9;
                    break;
                default:
                    throw new Exception("input is not a UnsignedInteger");
            }

            returnValue = returnValue + value*(int)Math.pow(10,limit-i-1);
        }

        return returnValue;
    }

    static public boolean inputIsSingleDigitNumber(String input){
        switch (input){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                return true;
            default:
                return false;
        }
    }
    static public boolean inputIsMoveUp(String input){
        return input.contentEquals("w")||input.contentEquals("W");
    }
    static public boolean inputIsMoveDown(String input){
        return input.contentEquals("s")||input.contentEquals("S");
    }
    static public boolean inputIsMoveLeft(String input){
        return input.contentEquals("a")||input.contentEquals("A");
    }
    static public boolean inputIsMoveRight(String input){
        return input.contentEquals("d")||input.contentEquals("D");
    }
    static public boolean inputIsShowHelp(String input){
        return input.contentEquals("h")||input.contentEquals("H");
    }
    static public boolean inputIsQuit(String input){
        return input.contentEquals("q")||input.contentEquals("Q");
    }
    static public boolean inputIsOpenInventory(String input){
        return input.contentEquals("i")||input.contentEquals("I");
    }

}
