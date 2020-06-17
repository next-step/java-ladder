package nextstep.ladder.domain.game;

import nextstep.ladder.domain.vo.Order;

import java.util.Map;

public class LadderGamePrize {
    private final Map<Order, String> ladderGamePrizes;

    public LadderGamePrize(final Map<Order, String> ladderGamePrizes) {
        this.ladderGamePrizes = ladderGamePrizes;
    }

    public String findByOrder(final Order order) {
        return ladderGamePrizes.get(order);
    }

    public int count() {
        return ladderGamePrizes.size();
    }
}
