package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @DisplayName("0 이하의 값으로 생성 시 오류")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void createHeightWithNegativeValue(int value) {
        Assertions.assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}