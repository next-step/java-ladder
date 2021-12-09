package step4.controller;

import org.junit.jupiter.api.Test;
import step4.domain.GameInfo;
import step4.domain.LadderInfo;
import step4.domain.Participants;
import step4.domain.Rewards;

class LadderGameTest {

    @Test
    void 게임_시작() {
        GameInfo gameInfo = GameInfo.of(Participants.of("a,b,c,d"), Rewards.of("1,2,3,4"));
        LadderGame ladderGame = LadderGame.create(gameInfo);

        ladderGame.start(LadderInfo.of(4, 5));
    }
}