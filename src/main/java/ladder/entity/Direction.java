package ladder.entity;

public enum Direction {

    STILL(0), LEFT(-1), RIGHT(1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int direction() {
        return this.direction;
    }
}
