package nextstep.ladder;

public class Point {
    private int index;
    private boolean hasLine;

    public Point(int index, boolean hasLine) {
        this.index = index;
        this.hasLine = hasLine;
    }

    public boolean hasLine() {
        return hasLine;
    }
}
