package nextstep.ladder.domain.game;

import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.vo.Order;

import java.util.Map;

public class LadderProcessSnapshot {
    private final Map<LadderGameUser, Order> snapshot;

    public LadderProcessSnapshot(final Map<LadderGameUser, Order> snapshot) {
        this.snapshot = snapshot;
    }

    public Order findOrderOf(final LadderGameUser gameUser) {
        return snapshot.get(gameUser);
    }

    public int count() {
        return snapshot.size();
    }
}
