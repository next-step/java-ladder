package ladder2.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("성공적으로 인스턴스화된다")
    void new_success() {
        assertThatNoException()
            .isThrownBy(() -> new Position(0));
    }

    @Test
    @DisplayName("음수일 경우 예외가 발생한다")
    void new_negative_exception() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
