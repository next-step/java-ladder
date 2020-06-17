package nextstep.ladder.domain;

import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.vo.Order;

import java.util.Map;

public class LadderGameSnapshot {
    private final Map<LadderGameUser, Order> snapshot;

    public LadderGameSnapshot(final Map<LadderGameUser, Order> snapshot) {
        this.snapshot = snapshot;
    }

    public Order findOrderOf(final LadderGameUser gameUser) {
        return snapshot.get(gameUser);
    }

    @Override
    public String toString() {
        return "LadderGameSnapshot{" +
                "snapshot=" + snapshot +
                '}';
    }
}
