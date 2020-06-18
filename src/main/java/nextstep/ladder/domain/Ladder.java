package nextstep.ladder.domain;

import nextstep.ladder.domain.user.LadderGameUserStore;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

public class Ladder {
    private final int maxHeight;
    private final LadderGameUserStore ladderGameUserStore;
    private final LadderLines ladderLines;

    private Ladder(final int maxHeight, final LadderGameUserStore userStore, final LadderLines ladderLines) {
        this.maxHeight = maxHeight;
        this.ladderGameUserStore = userStore;
        this.ladderLines = ladderLines;
    }

    public static Ladder of(final int maxHeight, final LadderGameUserStore userStore, final LadderLines ladderLines) {
        return new Ladder(maxHeight, userStore, ladderLines);
    }

    public int getMaxHeight() {
        return maxHeight;
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
