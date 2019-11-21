package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    private Direction direction;

    @BeforeEach
    void setUp() {
        direction = new Direction(false, true);
    }

    @Test
    @DisplayName("같은 값일 때 객체주소 값 비교")
    void directionEqualsWhenSameValue() {
        // give
        Direction testDirection = new Direction(false, true);

        // when
        boolean isSame = testDirection.equals(direction);

        // then
        assertThat(isSame).isTrue();
    }

    @Test
    @DisplayName("좌우 모두 참 일시 예외 처리")
    void directionWhenBothTrue() {
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            // give
            Direction direction = new Direction(true, true);
        });
    }
}
