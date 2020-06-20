package ladder.domain.ladder;

import ladder.domain.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("Direction 객체 생성 테스트")
    public void generateDirection() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("왼쪽 방향 연결된 다음 Point 의 Direction 생성 테스트")
    public void generateDirectionWithLeftLine() {
        Direction next = Direction.first(true).next(new RandomLineStrategy());
        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("왼쪽방향으로 연결되지 않은 다음 Point 의 Direction 생성 테스트")
    public void generateDirectionWithoutLeftLine() {
        Direction next = Direction.first(false).next(new RandomLineStrategy());
        assertThat(next).isInstanceOf(Direction.class);
    }

    @Test
    @DisplayName("오른쪽으로 연결된 Point 의 Direction 생성 테스트")
    public void generateDirectionWithRightLine() {
        Direction next = Direction.of(true, false).next(true);
        assertThat(next).isEqualTo(Direction.of(false, true));
    }

    @Test
    @DisplayName("오른쪽으로 연결되지 않은 Point 의 Direction 생성 테스트")
    public void generateDirectionWithoutRightLine() {
        Direction next = Direction.of(false, true).next(false);
        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("첫번째 Point의 Direction 생성 테스트")
    public void generateDirectionOfFirstPoint() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("마지막 Point의 Direction 생성 테스트")
    public void generateDirectionOfLastPoint() {
        Direction last = Direction.first(true).last();
        assertThat(last.isRight()).isFalse();
    }

    @Test
    @DisplayName("같은 방향을 가진 Direction객체의 HashCode 테스트")
    public void testHashCode() {
        assertThat(Direction.of(false, true).hashCode()).isEqualTo(Direction.of(false, true).hashCode());
    }
}
