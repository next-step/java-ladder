package ladder;

public class Point {
    private final int linePosition;
    private final int heightPosition;

    public Point(int linePosition, int heightPosition) {
        this.linePosition = linePosition;
        this.heightPosition = heightPosition;
    }

    public int getLinePosition() {
        return linePosition;
    }

    private int getHeightPosition() {
        return this.heightPosition;
    }
}
