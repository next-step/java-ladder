package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.ladder.concrete.TestLadder;
import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.laddergame.engine.LadderGame;
import nextstep.refactoring.laddergame.engine.LadderGameResult;
import nextstep.refactoring.laddergame.engine.PlayerNameKeyword;
import nextstep.refactoring.laddergame.engine.player.Players;
import nextstep.refactoring.laddergame.engine.reward.Rewards;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameImplTest {

    static LadderGame ladderGame;
    static Players players;
    static Rewards rewards;

    @BeforeAll
    static void beforeAll() {
        ladderGame = new LadderGameImpl(TestLadder.ladder());
        players = Players.of("pobi", "honux", "crong", "jk");
        rewards = Rewards.of("꽝", "5000", "꽝", "3000");
    }

    @Test
    @DisplayName("특정 참가자의 결과를 반환한다.")
    void returnLadderGameResultOfSpecificPlayer() {
        String honux = "honux";


        List<LadderGameResult> result = ladderGame.getResult(players, rewards, new PlayerNameKeyword(honux));
        LadderGameResult expected = new LadderGameResultImpl(players.get(Position.of(1)), rewards.get(Position.of(3)));

        assertThat(result).containsExactly(expected);
    }

    @Test
    @DisplayName("모든 참가자의 결과를 반환한다.")
    void getResultsOfAllPlayers() {
        String all = "all";

        List<LadderGameResult> result = ladderGame.getResult(players, rewards, new PlayerNameKeyword(all));

        List<LadderGameResult> expected = Arrays.asList(
            new LadderGameResultImpl(players.get(Position.of(0)), rewards.get(Position.of(0))),
            new LadderGameResultImpl(players.get(Position.of(1)), rewards.get(Position.of(3))),
            new LadderGameResultImpl(players.get(Position.of(2)), rewards.get(Position.of(2))),
            new LadderGameResultImpl(players.get(Position.of(3)), rewards.get(Position.of(1)))
        );

        assertThat(result).containsExactlyElementsOf(expected);
    }
    
}
