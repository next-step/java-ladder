package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @DisplayName("사다리 높이가 1 미만일 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -10})
    void ladder_height_greater_than_0(int negativeNumber) {
        Assertions.assertThatThrownBy(() -> Height.from(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
