package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    @ParameterizedTest(name = "사다리 높이 = {0}")
    @ValueSource(ints = 0)
    @DisplayName("사다리 높이는 1이상이 아닌 경우 생성할 수 없다")
    void does_not_create_ladder(int height) {
        assertThatThrownBy(() -> Height.of(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상의 값이어야 합니다.");
    }
}