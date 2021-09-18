package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @ParameterizedTest
    @CsvSource({"4, 0, 1", "6, 1, 0"})
    @DisplayName("사다리 모양에 따른 climb 결과 테스트")
    public void climb(int height, int zeroResult, int oneResult) {
        Ladder ladder = new Ladder(2, height);
        int width0 = 0;
        int width1 = 1;

        assertThat(ladder.climb(width0)).isEqualTo(0);
        assertThat(ladder.climb(width1)).isEqualTo(1);

        ladder.drawSteps(new OneByTwoDrawStrategy(true));

        assertThat(ladder.climb(width0)).isEqualTo(zeroResult);
        assertThat(ladder.climb(width1)).isEqualTo(oneResult);
    }
}