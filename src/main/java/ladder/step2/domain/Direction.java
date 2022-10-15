package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.PartLineCreateStrategy;
import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;

public class Direction {
    private final PartLine leftPartLine;
    private final PartLine rightPartLine;
    
    public Direction(final PartLine leftPartLine, final PartLine rightPartLine) {
        this.leftPartLine = leftPartLine;
        this.rightPartLine = rightPartLine;
    }
    
    public static Direction createFirst(PartLineCreateStrategy partLineCreateStrategy) {
        return new Direction(new PartLine(false), partLineCreateStrategy.create());
    }
    
    public Direction createLast() {
        return new Direction(rightPartLine, new PartLine(false));
    }
    
    public Direction createNext(PartLineCreateStrategy partLineCreateStrategy) {
        if (rightPartLine.isExist()) {
            return new Direction(rightPartLine, new PartLine(false));
        }
    
        return new Direction(rightPartLine, partLineCreateStrategy.create());
    }
    
    public boolean isLeft() {
        return leftPartLine.isExist();
    }
    
    public boolean isRight() {
        return rightPartLine.isExist();
    }
}
