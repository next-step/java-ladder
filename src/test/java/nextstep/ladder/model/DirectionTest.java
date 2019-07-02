package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class DirectionTest {
    private Direction direction;

    @BeforeEach
    void setUp() {
        direction = Direction.first(true);
    }

    @DisplayName("양쪽에 분기가 있는 Direction은 예외발생")
    @Test
    void 양쪽_true_예외발생() {
        assertThatIllegalStateException().isThrownBy(() -> Direction.of(true, true));
    }

    @DisplayName("다음 Direction이 {true, false} 되도록 변경")
    @Test
    void nextTest() {
        assertThat(direction.next(false).equals(Direction.of(true, false))).isTrue();
    }
}
