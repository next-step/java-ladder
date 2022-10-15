package ladder.step2.domain;

public class Direction {
    private final PartLine leftPartLine;
    private final PartLine rightPartLine;
    
    public Direction(final PartLine leftPartLine, final PartLine rightPartLine) {
        this.leftPartLine = leftPartLine;
        this.rightPartLine = rightPartLine;
    }
    
    public static Direction createFirst() {
        return new Direction(new PartLine(false), PartLineFactory.random());
    }
    
    public boolean isLeft() {
        return leftPartLine.isExist();
    }
    
    public boolean isRight() {
        return rightPartLine.isExist();
    }
}
