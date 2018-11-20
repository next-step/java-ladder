package model;

import java.util.List;

public class Position {
    private Positive x;
    private Positive y;

    public Position(Positive x, Positive y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 아래로 이동
     */
    public void moveDown() {
        y.decrease();
    }

    /**
     * 왼쪽 아래로 이동
     */
    public void moveLeftDown() {
        x.decrease();
        y.decrease();
    }

    /**
     * 오른쪽 아래로 이동
     */
    public void moveRightDown() {
        x.increase();
        y.decrease();
    }

    public Positive getX() {
        return x;
    }

    public Positive getY() {
        return y;
    }

    /**
     * y좌표가 0인지?
     * @return
     */
    public boolean isZeroY() {
        return 0 == y.getNum();
    }

    /**
     * 이동
     * @param lines
     * @param position
     * @return
     */
    public static Position move(List<Line> lines, Position position) {
        if (position.isZeroY()) {
            return position;
        }

        Positive x = position.getX();
        int num = x.getNum();
        Line line = lines.get(getLineIndex(lines, position));

        if (line.hasLine(num)) {
            position.moveRightDown();
            return move(lines, position);
        }

        if (line.hasLeftLine(x)) {
            position.moveLeftDown();
            return move(lines, position);
        }

        position.moveDown();
        return move(lines, position);
    }

    private static int getLineIndex(List<Line> lines, Position position) {
        return lines.size() - position.getY().getNum();
    }
}



