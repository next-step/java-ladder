package domain;

import java.util.List;

public class Ladder {

    private final List<Bridges> bridges;

    public Ladder(List<Bridges> bridges) {
        this.bridges = bridges;
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

    public void accept(LadderVisitor visitor) {
        visitor.visitBridges(bridges);
    }
}
