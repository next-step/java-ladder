package ladder.step2.domain;

public class Point {
    private final boolean leftLine;
    private final boolean rightLine;
    
    public Point(final boolean leftLine, final boolean rightLine) {
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }
    
    public int move(final int currentPosition) {
        return currentPosition;
    }
}
