package ladder.domain;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getRightPosition() {
        return this.x + 1;
    }

    public int getLeftPosition() {
        return this.x - 1;
    }
}
