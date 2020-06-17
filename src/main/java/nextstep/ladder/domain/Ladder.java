package nextstep.ladder.domain;

public class Ladder {
    private final int maxPoint;
    private final LadderGameUsers ladderGameUsers;
    private final LadderLines ladderLines;

    private Ladder(final int maxPoint, final LadderGameUsers ladderGameUsers, final LadderLines ladderLines) {
        this.maxPoint = maxPoint;
        this.ladderGameUsers = ladderGameUsers;
        this.ladderLines = ladderLines;
    }

    public static Ladder of(final int maxHeight, final LadderGameUsers ladderGameUsers, final LadderLines ladderLines) {
        return new Ladder(maxHeight, ladderGameUsers, ladderLines);
    }

    public boolean connected(final int orderValue, final int pointValue) {
        return ladderLines.findLadderLineByOrder(orderValue).connectedWith(pointValue);
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public int getNumberOfUsers() {
        return ladderLines.count();
    }

    public LadderGameUsers getLadderGameUsers() {
        return ladderGameUsers;
    }

    public boolean hasConnection(final Order order, final Point point) {
        LadderLine ladderLine = ladderLines.findLadderLineByOrder(order);
        return ladderLine.connectedWith(point);
    }
}
