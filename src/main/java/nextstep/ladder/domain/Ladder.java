package nextstep.ladder.domain;

import nextstep.ladder.domain.user.LadderGameUserStore;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

public class Ladder {
    private final int maxPoint;
    private final LadderGameUserStore ladderGameUserStore;
    private final LadderLines ladderLines;

    private Ladder(final int maxPoint, final LadderGameUserStore ladderGameUserStore, final LadderLines ladderLines) {
        this.maxPoint = maxPoint;
        this.ladderGameUserStore = ladderGameUserStore;
        this.ladderLines = ladderLines;
    }

    public static Ladder of(final int maxHeight, final LadderGameUserStore ladderGameUserStore, final LadderLines ladderLines) {
        return new Ladder(maxHeight, ladderGameUserStore, ladderLines);
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

    public LadderGameUserStore getLadderGameUsers() {
        return ladderGameUserStore;
    }

    public boolean hasConnection(final Order order, final Point point) {
        LadderLine ladderLine = ladderLines.findLadderLineByOrder(order);
        return ladderLine.connectedWith(point);
    }
}
