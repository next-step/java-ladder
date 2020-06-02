package nextstep.ladder.ui;

import nextstep.ladder.domain.GameResults;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Rewards;
import org.junit.jupiter.api.BeforeEach;

class GameResultsOutputViewTests {
    private GameResults gameResults;

    @BeforeEach
    public void setup() {
        Players players = Players.create("poppo, ita, saul");
        Rewards rewards = Rewards.create("1, 2, 3");

        gameResults = GameResults.create(players, rewards);
    }
}
