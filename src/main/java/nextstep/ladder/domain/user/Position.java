package nextstep.ladder.domain.user;

public class Position {

    private int x;
    private int y;

    public Position(int x) {
        this(x, 0);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRight() {
        x++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveDown() {
        y++;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
