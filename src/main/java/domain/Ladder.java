package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Lines lines;
    private final List<Bridges> bridges;

    public Ladder(int playerCount, int height) {
        this(Lines.of(playerCount, height));
    }

    public Ladder(Lines lines) {
        this.lines = lines;
        this.bridges = new ArrayList<>();
    }

    public Ladder(List<Bridges> bridges) {
        this.bridges = bridges;
        this.lines = null;
    }

    public void accept(LadderVisitor visitor) {
        lines.accept(visitor);
    }

    public Position getEndPositionByStartPosition(Position startPosition) {
        Position position = startPosition;
        while (position.getY() < lines.getHeight()) {
            Position move = lines.move(position);
            position = new Position(move.getX(), move.getY() + 1);
        }
        return position;
    }

    public int getEndColumn(int startColumn) {
        int column = startColumn;
        for (int row = 0; row < bridges.size(); row++) {
            column = getNextColumn(row, column);
        }
        return column;
    }

    private int getNextColumn(int i, int column) {
        Direction dir = bridges.get(i).move(column);
        if (dir.isSame(Direction.RIGHT)) {
            column += 1;
        }
        if (dir.isSame(Direction.LEFT)) {
            column -= 1;
        }
        return column;
    }
}
