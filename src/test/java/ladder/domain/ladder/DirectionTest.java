package ladder.domain.ladder;

import ladder.domain.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    public static final Direction rightDirection = Direction.of(false, true);
    public static final Direction leftDirection = Direction.of(true, false);
    public static final Direction noneDirection = Direction.of(false, false);

    @Test
    @DisplayName("왼쪽 방향 연결된 다음 Point 의 Direction 생성 테스트")
    public void generateDirectionWithLeftLine() {
        Direction next = rightDirection.next(new RandomLineStrategy());
        assertThat(next).isEqualTo(leftDirection);
    }

    @Test
    @DisplayName("왼쪽방향으로 연결되지 않은 다음 Point 의 Direction 생성 테스트")
    public void generateDirectionWithoutLeftLine() {
        Direction next = noneDirection.next(new RandomLineStrategy());
        assertThat(next).isInstanceOf(Direction.class);
    }

    @Test
    @DisplayName("오른쪽으로 연결된 Point 의 Direction 생성 테스트")
    public void generateDirectionWithRightLine() {
        Direction next = leftDirection.next(true);
        assertThat(next.isRight()).isEqualTo(true);
    }

    @Test
    @DisplayName("오른쪽으로 연결되지 않은 Point 의 Direction 생성 테스트")
    public void generateDirectionWithoutRightLine() {
        Direction next = rightDirection.next(false);
        assertThat(next).isEqualTo(leftDirection);
    }

    @Test
    @DisplayName("첫번째 Point의 Direction 생성 테스트")
    public void generateDirectionOfFirstPoint() {
        Direction first = Direction.first(true);
        assertThat(first).isEqualTo(rightDirection);
    }

    @Test
    @DisplayName("마지막 Point의 Direction 생성 테스트")
    public void generateDirectionOfLastPoint() {
        Direction last = rightDirection.last();
        assertThat(last).isEqualTo(leftDirection);
    }

    @Test
    @DisplayName("같은 방향을 가진 Direction객체의 HashCode 테스트")
    public void testHashCode() {
        assertThat(rightDirection.hashCode()).isEqualTo(rightDirection.hashCode());
    }

    @Test
    @DisplayName("양 방향으로 연결된 경우 예외 발생")
    public void throwExceptionWhenBothDirection() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.of(true,true);
        }).withMessageMatching("Cannot have both directions.");
    }
}
