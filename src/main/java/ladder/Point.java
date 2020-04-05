package ladder;

public class Point {
    private final int heightPosition;
    private final int endPointLineNo;

    public Point(int heightPosition, int endPointLineNo) {
        this.heightPosition = heightPosition;
        this.endPointLineNo = endPointLineNo;
    }

    public int getHeightPosition() {
        return heightPosition;
    }

    public int getEndPointLineNo() {
        return endPointLineNo;
    }
}
