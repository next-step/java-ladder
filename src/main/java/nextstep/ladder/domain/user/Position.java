package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.Lines;
import nextstep.ladder.domain.ladder.Points;

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

    public boolean movable(Lines lines) {
        return y < lines.size();
    }

    public void move(Lines lines) {
        Points points = lines.getRow(y);
        Direction movableDirection = getMovableDirection(points);
        movableDirection.move(this);
    }

    private Direction getMovableDirection(Points points) {
        final int maxPositionX = points.size();
        if (isFarLeft() && points.isConnected(x)) {
            return Direction.RIGHT;
        }
        if (isFarRight(maxPositionX) && points.isConnected(x - 1)) {
            return Direction.LEFT;
        }
        if (isNotFarLeft() && points.isConnected(x - 1)) {
            return Direction.LEFT;
        }
        if (isNotFarRight(maxPositionX) && points.isConnected(x)) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
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
