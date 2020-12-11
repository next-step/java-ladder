package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {

    private GameResults gameResults;

    @BeforeEach
    void SetUp() {
        Users users = Users.of("pobi,honux,crong,jk");
        Lines lines = Lines.of(GameSetup.of(4,5),() -> true);
        GameReward gameReward = GameReward.of("꽝,5000,꽝,3000");
        this.gameResults = GameResults.of(users,lines,gameReward);
    }

    @Test
    @DisplayName("GameResults 객체 비교")
    void gameResults_results_isEqualTo() {
        Users users = Users.of("pobi,honux,crong,jk");
        Lines lines = Lines.of(GameSetup.of(4,5),() -> true);
        GameReward gameReward = GameReward.of("꽝,5000,꽝,3000");

        assertThat(gameResults).isEqualTo(GameResults.of(users,lines,gameReward));
    }
}
