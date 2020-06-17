package nextstep.ladder.domain;

import nextstep.ladder.domain.user.LadderGameUserStore;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

public class Ladder {
    private final Point maxPoint;
    private final LadderGameUserStore ladderGameUserStore;
    private final LadderLines ladderLines;

    private Ladder(final Point maxPoint, final LadderGameUserStore userStore, final LadderLines ladderLines) {
        this.maxPoint = maxPoint;
        this.ladderGameUserStore = userStore;
        this.ladderLines = ladderLines;
    }

    public static Ladder of(final Point maxHeight, final LadderGameUserStore userStore, final LadderLines ladderLines) {
        return new Ladder(maxHeight, userStore, ladderLines);
    }

    public Point getMaxPoint() {
        return maxPoint;
    }

    public int getNumberOfUsers() {
        return ladderLines.count();
    }

    public LadderGameUserStore getLadderGameUsers() {
        return ladderGameUserStore;
    }

    public boolean hasConnection(final Order order, final Point point) {
        return ladderLines.hasConnection(order, point);
    }

    public boolean hasConnection(final int order, final int point) {
        return ladderLines.hasConnection(order, point);
    }
}
