package ladder.step2.domain;

public class Direction {
    private final PartLine leftPartLine;
    private final PartLine rightPartLine;
    
    public Direction(final boolean leftPartLine, final boolean rightPartLine) {
        this.leftPartLine = new PartLine(leftPartLine);
        this.rightPartLine = new PartLine(rightPartLine);
    }
    
    public boolean isLeft() {
        return leftPartLine.isExist();
    }
    
    public boolean isRight() {
        return rightPartLine.isExist();
    }
}
