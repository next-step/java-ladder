package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @ParameterizedTest
    @DisplayName("최대 사다리 높이는 0이하이면 예외(0 => IllegalArgumentException)")
    @ValueSource(ints = {0, -1})
    void height_larger_than_0(int height) {
        assertThatThrownBy(() -> {
            new Height(height);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
