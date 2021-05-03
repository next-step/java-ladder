package ladder2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder2.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    @DisplayName("Direction 비교 테스트")
    void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("잘못된 방향을 가진 경우, 예외를 던진다.")
    void wrongDirectionTest() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("첫 포인트에 |------ 형태로 Bridge가 생성되면, 다음 포인트는 ------| 형태가 된다.")
    void nextRandomTrueTest() {
        Direction next = Direction.first(true).next();

        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("첫 포인트에 다리를 안만들었다면, 다음 포인트는 |------ 이거나     |      이다.")
    void nextRandomFalseTest() {
        for (int i = 0; i < 100; i++) {
            Direction direction = Direction.first(false).next();

            assertThat(direction.isLeft()).isEqualTo(false);
        }
    }

    @Test
    @DisplayName("------|    인 경우, next(true)를 할 경우, 다음 포인트에서      |------ 이다.")
    void nextTrueTest() {
        Direction next = Direction.of(true, false).next(true);

        assertThat(next).isEqualTo(Direction.of(false, true));
    }

    @Test
    @DisplayName("     |------ 인 경우, next(false)를 할 경우, 다음 포인트에서  -------|     이다.")
    void nextFalseTest() {
        Direction next = Direction.of(false, true).next(false);

        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("첫 포인트에는 왼쪽으로 향하는 다리를 생성할 수 없다.")
    void firstPointTest() {
        Direction first= Direction.first(true);

        assertThat(first.isLeft()).isEqualTo(false);
    }

    @Test
    @DisplayName("마지막 포인트에는 오른쪽으로 향하는 다리를 생성할 수 없다.")
    void lastPointTest() {
        Direction last = Direction.first(true).last();

        assertThat(last).isEqualTo(Direction.of(true, false));
    }

}
