package ladder.domain;

public class LadderLineInfo {
    private final int lineCount;
    private final DirectionCreator directionCreator;

    public LadderLineInfo(final int lineCount, final DirectionCreator directionCreator) {
        this.lineCount = lineCount;
        this.directionCreator = directionCreator;
    }

    public int lineCount() {
        return lineCount;
    }

    public boolean createDirection() {
        return directionCreator.create();
    }
}
