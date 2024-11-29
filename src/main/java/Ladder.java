import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int height() {
        return this.lines.size();
    }

    public long playerCount() {
        return this.lines.get(0).nodeCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;

        return this.lines.equals(ladder.lines);
    }

    public int travel(int playerNumber) {
        Dot curDot = new Dot(playerNumber * 2, 0, DotType.NODE);

        boolean horizontalMovable = true;
        while (curDot.getY() < height()) {
            if (availLeft(curDot) && horizontalMovable) {
                curDot = curDot.moveLeft();
                horizontalMovable = false;
                continue;
            }

            if(availRight(curDot) && horizontalMovable) {
                curDot = curDot.moveRight();
                horizontalMovable = false;
                continue;
            }

            curDot = curDot.moveDown();
            horizontalMovable = true;
        }

        return curDot.getX();
    }

    private boolean availRight(Dot curDot) {
        Line line = this.lines.get(curDot.getY());

        if (curDot.getX() == line.size() - 1) { return false; }

        return line.isBridge(curDot.getX() + 1);
    }

    private boolean availLeft(Dot curDot) {
        Line line = this.lines.get(curDot.getY());

        if (curDot.getX() == 0) { return false; }

        return line.isBridge(curDot.getX() - 1);
    }
}
