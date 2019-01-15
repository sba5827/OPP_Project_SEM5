package ProjectOOP.Game;

public class XY_Position{

    int x;
    int y;

    public XY_Position(int x, int y){

        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(XY_Position position){
        return (this.x == position.x && this.y == position.y);
    }

    public boolean equals(int x, int y){
        return (this.x == x && this.y == y);
    }

    public XY_Position copy(){
        return new XY_Position(x,y);
    }

}
