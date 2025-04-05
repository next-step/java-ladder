package nextstep.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("사다리의 높이는 1보다 작으면 안된다.")
    public void checkValidLadderHeight(int value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}