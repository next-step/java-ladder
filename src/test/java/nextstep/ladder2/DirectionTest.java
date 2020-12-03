package nextstep.ladder2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Direction 요구사항
 *
 * * 특정 지점의 오른쪽/왼쪽 이동가능한지를 나타낸다
 * * 좌측 끝지점은 항상 왼쪽은 이동이 불가능하다
 * * 우측 끝지점은 항상 오른쪽 이동이 불가능하다
 * * 중간지점은 왼쪽 또는 오른쪽으로 이동가능하나 둘다 이동가능할 순 없다. 단 둘다 이동불가능함은 가능하다.
 * * 다음 오른쪽 지점을 나타내는 객체를 생성하는 함수를 제공한다.
 */
public class DirectionTest {
    @DisplayName("왼쪽/오른쪽 이동 가능한지를 표현한다")
    @Test
    void create() {
        assertAll(
                () -> assertThat(Direction.of(true, false))
                        .isEqualTo(Direction.of(true, false)),
                () -> assertThat(Direction.of(false, true))
                        .isEqualTo(Direction.of(false, true)),
                () -> assertThat(Direction.of(false, false))
                        .isEqualTo(Direction.of(false, false))
        );
    }

    private static class Direction {
        private static final Direction LEFT = new Direction(true, false);

        public Direction(boolean left, boolean right) {

        }

        public static Direction of(boolean left, boolean right) {
            if (left) {
                return LEFT;
            }
            return null;
        }
    }
}
