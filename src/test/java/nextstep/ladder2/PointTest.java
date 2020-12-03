package nextstep.ladder2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Point 요구사항
 * <p>
 * * 포인트는 위치와 이동가능여부(Direction) 을 가진다.
 * * 이동 함수를 제공하며 위치값을 반환한다
 */
public class PointTest {
    @Test
    void create() {
        new Point(0, Direction.of(false, true));
    }

    @DisplayName("첫번째 지점은 오른쪽 이동가능여부를 입력받는다")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void first(boolean right) {
        assertThat(Point.first(right)).isEqualTo(new Point(0, Direction.of(false, right)));
    }

    @DisplayName("이동하면 위치값을 리턴한다")
    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    void move(boolean right, int index) {
        assertThat(Point.first(right).move()).isEqualTo(index);
    }

    private static class Point {
        private final int index;
        private final Direction direction;

        Point(int index, Direction direction) {
            this.index = index;
            this.direction = direction;
        }

        public static Point first(boolean right) {
            return new Point(0, Direction.first(right));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Point point = (Point) o;
            return index == point.index && direction.equals(point.direction);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, direction);
        }

        public int move() {
            if (direction.isRight()) {
                return index + 1;
            }
            return index;
        }
    }
}
