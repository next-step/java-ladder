package nextstep.ladder.domain.game;

import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.vo.Order;

public class LadderGameResult {
    private final LadderGameSnapshot ladderGameSnapshot;
    private final LadderGamePrize ladderGamePrize;

    public LadderGameResult(final LadderGameSnapshot ladderGameSnapshot, final LadderGamePrize ladderGamePrize) {
        this.ladderGameSnapshot = ladderGameSnapshot;
        this.ladderGamePrize = ladderGamePrize;
        if (ladderGameSnapshot.count() != ladderGamePrize.count()) {
            throw new IllegalArgumentException("사용자와 상품은 일치해야합니다");
        }
    }

    public String getPrizeOf(LadderGameUser gameUser) {
        Order order = ladderGameSnapshot.findOrderOf(gameUser);
        return ladderGamePrize.findByOrder(order);
    }
}
