package nextstep.ladder.domain.game;

import nextstep.ladder.domain.gameresult.GameResults;
import nextstep.ladder.domain.ladder.HorizontalLocation;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.SimplePointAddStrategy;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTests {
    private Players players;
    private Ladder ladder;

    @BeforeEach
    public void setup() {
        players = Players.create(Arrays.asList("saul", "poppo", "ita"));
        ladder = Ladder.create(5, 3, new SimplePointAddStrategy());
    }

    @DisplayName("Players, Ladder를 전달 받아서 사다리 게임을 진행할 수 있다.")
    @Test
    void initLadderGameTest() {
        LadderGame ladderGame = LadderGame.readyLadderGame(players, ladder);

        assertThat(ladderGame).isNotNull();
    }

    @DisplayName("Rewards를 전달받아서 게임을 진행하고 결과를 볼 수 있다.")
    @Test
    void playGame() {
        LadderGame ladderGame = LadderGame.readyLadderGame(players, ladder);
        Rewards rewards = Rewards.create("1, 2, 3");

        GameResults gameResults = ladderGame.playGame(rewards);

        Players expectedPlayers = new Players(Arrays.asList(
                new Player("saul", new HorizontalLocation(1, 3)),
                new Player("poppo", new HorizontalLocation(0, 3)),
                new Player("ita", new HorizontalLocation(2, 3))
        ));
        assertThat(gameResults).isEqualTo(GameResults.create(expectedPlayers, rewards));
    }
}
