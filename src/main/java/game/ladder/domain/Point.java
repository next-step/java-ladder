package game.ladder.domain;

/**
 * Created by yusik on 2019/11/10.
 */
public class Point {

    private boolean movable;

    public Point(boolean movable) {
        this.movable = movable;
    }

    public boolean movable() {
        return movable;
    }
}
