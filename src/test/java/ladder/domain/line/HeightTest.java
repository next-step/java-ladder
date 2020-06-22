package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {

    @DisplayName("입력 값이 1보다 작으면 예외 발생")
    @Test
    void valueOfInvalidRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Height.valueOf(0));
    }
}
