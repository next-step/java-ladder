package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.Direction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    private Direction direction;

    @BeforeEach
    void setUp() {
        direction = Direction.of(false, true);
    }

    @Test
    @DisplayName("같은 값일 때 객체주소 값 비교")
    void directionEqualsWhenSameValue() {
        // give
        Direction testDirection = Direction.of(false, true);
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
            Direction direction = Direction.of(true, true);
        });
    }

    @Test
    @DisplayName("다음 값 비교 파라미터 포함")
    void nextTestWithParameter() {
        // give
        Direction directionRight = Direction.of(false, true);
        Direction directionLeft = Direction.of(true, false);
        // when
        boolean isSameRight = directionRight.equals(Direction.of(true, false).next(true));
        boolean isSameLeft = directionLeft.equals(Direction.of(false, true).next(false));
        // then
        assertThat(isSameRight).isTrue();
        assertThat(isSameLeft).isTrue();
    }

    @Test
    @DisplayName("다음 값 비교")
    void nextTestNoneParameter() {
        // give
        Direction direction = Direction.of(false, true);
        // when
        Direction nextDirection = direction.next(false);
        // then
        assertThatIllegalArgumentException().isThrownBy(() ->
                assertThat(nextDirection).isNotEqualTo(Direction.of(true, true)));
    }

    @Test
    @DisplayName("첫 인덱스 값 비교")
    void DirectionFirst() {
        // give
        Direction firstDirection = Direction.first(true);
        Direction direction = Direction.of(false, true);
        // when
        boolean isSame = firstDirection.equals(direction);
        // then
        assertThat(isSame).isTrue();
    }

    @Test
    @DisplayName("마지막 원시 값 비교")
    void DirectionLast() {
        // give
        Direction lastDirection = Direction.of(false, true).last();
        // when
        boolean isSame = Boolean.FALSE.equals(lastDirection.isRight());
        // then
        assertThat(isSame).isTrue();
    }
}
