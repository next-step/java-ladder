package nextstep.ladder.ui;

import nextstep.ladder.domain.gameresult.GameResults;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsOutputViewTests {
    private GameResults gameResults;

    @BeforeEach
    public void setup() {
        Players players = Players.create(Arrays.asList("poppo", "ita", "saul"));
        Rewards rewards = Rewards.create("1, 2, 3");

        gameResults = GameResults.create(players, rewards);
    }

    @DisplayName("개인의 사다리 게임 상품 결과를 확인할 수 있음")
    @Test
    void getIndividualResultTest() {
        GameResultsOutputView gameResultsOutputView = new GameResultsOutputView(gameResults);

        assertThat(gameResultsOutputView.parseIndividualResult("poppo"))
                .isEqualTo(System.lineSeparator() + "실행 결과" + System.lineSeparator() + "1");
    }

    @DisplayName("모든 종합 결과를 확인할 수 있음")
    @Test
    void getAllResultsTest() {
        GameResultsOutputView gameResultsOutputView = new GameResultsOutputView(gameResults);

        assertThat(gameResultsOutputView.parseAllResults()).contains("saul : 3");
        assertThat(gameResultsOutputView.parseAllResults()).contains("poppo : 1");
        assertThat(gameResultsOutputView.parseAllResults()).contains("ita : 2");
    }
}
