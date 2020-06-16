package nextstep.ladder.domain;

public class Ladder {
    private final int maxHeight;
    private final LadderLines ladderLines;

    private Ladder(final int maxHeight, final LadderLines ladderLines) {
        this.maxHeight = maxHeight;
        this.ladderLines = ladderLines;
    }

    public static Ladder of(final int maxHeight, final LadderLines ladderLines) {
        return new Ladder(maxHeight, ladderLines);
    }

    public String findUserNameByOrder(final int orderValue) {
        return ladderLines.findLadderLineByOrder(orderValue).getUserName();
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getNumberOfUsers() {
        return ladderLines.count();
    }

    public boolean connected(final int orderValue, final int pointValue) {
        return ladderLines.findLadderLineByOrder(orderValue).connectedWith(pointValue);
    }
}
