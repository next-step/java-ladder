package ladder.domain;

public class Point {
    private final int heightPosition;
    private final int endPointLineNo;

    public Point(int heightPosition, int endPointLineNo) {
        this.heightPosition = heightPosition;
        this.endPointLineNo = endPointLineNo;
    }

    public int getEndPointLineNo() {
        return endPointLineNo;
    }

    public boolean isHeightPosition(int heightPosition) {
        return this.heightPosition == heightPosition;
    }

    public boolean isEndPointLineNumber(int endPointLineNo) {
        return this.endPointLineNo == endPointLineNo;
    }
}
