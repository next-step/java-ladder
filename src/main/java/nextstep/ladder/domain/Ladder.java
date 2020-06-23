package nextstep.ladder.domain;

import nextstep.ladder.domain.user.LadderGameUserStorage;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;

public class Ladder {
    private final int maxHeight;
    private final LadderGameUserStorage ladderGameUserStorage;
    private final LadderLines ladderLines;

    private Ladder(final int maxHeight, final LadderGameUserStorage userStore, final LadderLines ladderLines) {
        this.maxHeight = maxHeight;
        this.ladderGameUserStorage = userStore;
        this.ladderLines = ladderLines;
    }

    public static Ladder of(final int maxHeight, final LadderGameUserStorage userStore, final LadderLines ladderLines) {
        return new Ladder(maxHeight, userStore, ladderLines);
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getNumberOfUsers() {
        return ladderLines.count();
    }

    public LadderGameUserStorage getLadderGameUsers() {
        return ladderGameUserStorage;
    }

    public boolean hasConnection(final Order order, final Point point) {
        return ladderLines.hasConnection(order, point);
    }

    public boolean hasConnection(final int order, final int point) {
        return ladderLines.hasConnection(order, point);
    }
}
