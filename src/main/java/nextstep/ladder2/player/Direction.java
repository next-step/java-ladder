package nextstep.ladder2.player;

public enum Direction {
    LEFT(1),RIGHT(2),STAY(0);
    private int direction;
    Direction(int direction){
        this.direction = direction;
    }
}
