package nextstep.step2;

import java.util.List;

public class Ladder {

    private final Lines lines;

    public Ladder(int height, int width, PointGenerator pointGenerator) {
        this.lines = new Lines(height, width, pointGenerator);
    }

    public int move(Position position) {
        while (position.getY() < lines.getHeight()) {
            position = moveHorizontally(position);
            position = position.moveVertically();
        }
        return position.getX();
    }

    private Position moveHorizontally(Position position) {
        if (canMoveLeft(position)) {
            return position.moveLeft();
        }
        if (canMoveRight(position)) {
            return position.moveRight();
        }
        return position;
    }

    private boolean canMoveLeft(Position position) {
        return position.getX() > 0 && lines.isConnected(position.getX() - 1, position.getY());
    }

    private boolean canMoveRight(Position position) {
        return position.getX() < lines.getWidth() - 1 && lines.isConnected(position.getX(), position.getY());
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
