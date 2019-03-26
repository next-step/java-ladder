package ladder.domain.ladder;

public class Point {
    private final boolean cross;

    public Point(boolean cross) {
        this.cross = cross;
    }

    public boolean isCross() {
        return cross;
    }
}
