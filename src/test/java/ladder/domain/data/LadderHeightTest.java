package ladder.domain.data;


import ladder.domain.exception.LadderException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 사다리_높이_0_또는_음수(int value) {
        assertThatExceptionOfType(LadderException.class)
            .isThrownBy(() -> new LadderHeight(value))
            .withMessage("사다리 높이는 0 이상이어야 합니다.");

    }
}