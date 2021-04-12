package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.ladder.concrete.TestLadder;
import nextstep.refactoring.laddergame.concrete.player.Player;
import nextstep.refactoring.laddergame.concrete.reward.Reward;
import nextstep.refactoring.laddergame.engine.LadderGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameImplTest {

    static LadderGame<Player, Reward> playerRewardLadderGame;
    static Players players;
    static Rewards rewards;

    @BeforeAll
    static void beforeAll() {
        playerRewardLadderGame = new LadderGameImpl(TestLadder.ladder());
        players = Players.of("pobi", "honux", "crong", "jk");
        rewards = Rewards.of("꽝", "5000", "꽝", "3000");
    }

    @Test
    @DisplayName("특정 참가자의 사다리 게임 결과를 가져온다.")
    void getLadderGameResultOfSpecificPlayer() {

    }
}
