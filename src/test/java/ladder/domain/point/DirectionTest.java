package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @DisplayName("first 테스트")
    @Test
    void firstTest() {
        assertThat(Direction.first(Boolean.TRUE).isLeft()).isFalse();
    }

    @DisplayName("left 테스트")
    @Test
    void leftTest() {
        assertThat(Direction.LEFT.isLeft()).isTrue();
        assertThat(Direction.LEFT.isRight()).isFalse();
    }

    @DisplayName("right 테스트")
    @Test
    void rightTest() {
        assertThat(Direction.RIGHT.isLeft()).isFalse();
        assertThat(Direction.RIGHT.isRight()).isTrue();
    }

    @DisplayName("next 테스트")
    @ParameterizedTest
    @EnumSource(value = Direction.class, names = {"LEFT", "RIGHT", "DOWN"})
    void nextTest(Direction direction) {
        if (direction.isRight()) {
            assertThat(direction.next(FALSE)).isEqualTo(Direction.LEFT);
        }

        if (direction.isLeft()) {
            assertThat(direction.next(FALSE)).isEqualTo(Direction.DOWN);
            assertThat(direction.next(TRUE)).isEqualTo(Direction.RIGHT);
        }
    }
}