package nextstep.ladder.domain.ladder;

public class Ladder {
    private LadderPosition position;
    private boolean hasHorizontalLine;

    public Ladder(int row, int column, boolean hasHorizontalLine) {
        this(new LadderPosition(row, column), hasHorizontalLine);
    }

    public Ladder(LadderPosition position, boolean hasHorizontalLine) {
        this.position = position;
        this.hasHorizontalLine = hasHorizontalLine;
    }

    public LadderPosition getPosition() {
        return position;
    }

    public boolean isHasHorizontalLine() {
        return hasHorizontalLine;
    }
}
