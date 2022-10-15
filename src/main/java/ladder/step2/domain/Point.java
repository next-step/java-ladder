package ladder.step2.domain;

public class Point {
    private final PartLine leftLine;
    private final PartLine rightLine;
    
    public Point(final boolean leftLine, final boolean rightLine) {
        this.leftLine = new PartLine(leftLine);
        this.rightLine = new PartLine(rightLine);
    }
    
    public int move(final int currentPosition) {
        if (leftLine.isExist()) {
            return currentPosition - 1;
        }
        
        if (rightLine.isExist()) {
            return currentPosition + 1;
        }
        
        return currentPosition;
    }
}
