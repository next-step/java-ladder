package nextstep.laddergame.model;

public class Position {

    private static final int LEFT_LIMIT = 0;

    private int cursur;

    public Position(int cursur) {
        this.cursur = cursur;
    }

    public boolean leftMovable() {
        return cursur > LEFT_LIMIT;
    }

    public boolean rigthMovable(int limit) {
        return cursur < limit;
    }

    public void moveLeft() {
        cursur--;
    }

    public void moveRight() {
        cursur++;
    }

    public int getCursur() {
        return cursur;
    }
}
