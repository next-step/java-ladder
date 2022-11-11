package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @DisplayName("높이가 1미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validate(int input) {
        assertThatThrownBy(() -> {
            new Height(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
