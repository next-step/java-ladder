package nextstep.ladder.domain;

import java.util.Map;

public class LadderGamePrize {
    private final Map<Order, String> ladderGamePrizes;

    public LadderGamePrize(final Map<Order, String> ladderGamePrizes) {
        this.ladderGamePrizes = ladderGamePrizes;
    }
}
