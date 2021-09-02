package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderHeightsTest {

    @ParameterizedTest(name = "사다리의 높이가 1 미만인 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 0})
    public void invalidLadderHeightTest(int invalidHeights) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderHeights.of(invalidHeights))
                .withMessageContaining(String.valueOf(invalidHeights));
    }

    @DisplayName("사다리의 높이는 1 이상이다.")
    @Test
    public void ladderHeightCreateTest() {
        LadderHeights ladderHeights = LadderHeights.of(5);
        assertThat(ladderHeights.getHeights())
                .isEqualTo(5);
    }
}