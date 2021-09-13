package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {
    @ParameterizedTest
    @CsvSource({"4, 0, 1", "6, 1, 0"})
    @DisplayName("사다리 모양에 따른 climb 결과 테스트")
    public void climb(int height, int zeroResult, int oneResult) {
        Ladder ladder = new Ladder(2, height);
        Player player0 = new Player(0);
        Player player1 = new Player(1);

        assertThat(player0.climb(ladder)).isEqualTo(0);
        assertThat(player1.climb(ladder)).isEqualTo(1);

        ladder.drawSteps(new OneByTwoDrawStrategy(true));

        assertThat(player0.climb(ladder)).isEqualTo(zeroResult);
        assertThat(player1.climb(ladder)).isEqualTo(oneResult);
    }
}