package ladder.dto;

public class Point {
    private boolean point;

    public Point(){
        this.point = getNewPoint();
    }

    public Point(boolean value){
        this.point = value;
    }

    private boolean getNewPoint() {
        int random = (int) (Math.random() * 10);
        return random % 2 == 0;
    }

    public boolean isTrue(){
        return this.point == true;
    }
}
