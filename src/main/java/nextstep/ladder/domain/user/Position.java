package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.Points;

import java.util.List;

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

    public boolean movable(List<Points> rows) {
        return y < rows.size();
    }

    public void move(List<Points> rows) {
        Points points = rows.get(y);
        moveToDirection(points);
        moveDown();
    }

    private void moveToDirection(Points points) {
        final int maxPositionX = points.size();
        if (isFarLeft() && points.isConnected(x)) {
            moveRight();
            return;
        }
        if (isFarRight(maxPositionX) && points.isConnected(x - 1)) {
            moveLeft();
            return;
        }
        if (isNotFarLeft() && points.isConnected(x - 1)) {
            moveLeft();
            return;
        }
        if (isNotFarRight(maxPositionX) && points.isConnected(x)) {
            moveRight();
        }
    }

    private boolean isFarRight(int rowSize) {
        return x == rowSize;
    }

    private boolean isNotFarRight(int rowSize) {
        return !isFarRight(rowSize);
    }


    private boolean isFarLeft() {
        return x == 0;
    }

    private boolean isNotFarLeft() {
        return !isFarLeft();
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
