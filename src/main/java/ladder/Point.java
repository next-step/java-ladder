package ladder;

public class Point {
    private final Boolean leftLine;
    private final Boolean rightLine;

    public Point(Boolean leftLine, Boolean rightLine) {
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }

    public boolean hasLeftLine() {
        return leftLine != null && leftLine;
    }

    public boolean hasRightLine() {
        return rightLine != null && rightLine;
    }


}
