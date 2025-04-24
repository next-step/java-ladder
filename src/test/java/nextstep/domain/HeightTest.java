package nextstep.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("높이는 0이나 음수가 될 수 없다")
    void negativeNumberTest(int number) {
        assertThatThrownBy(
            () -> Height.of(number)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
