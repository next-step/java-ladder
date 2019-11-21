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

    @Test
    @DisplayName("다음 값 비교 파라미터 포함")
    void nextTestWithParameter() {
        // give
        Direction directionRight = new Direction(false, true);
        Direction directionLeft = new Direction(true, false);
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
        Direction nextDirection = direction.next();
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
