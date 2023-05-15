package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    @DisplayName("좌표 생성")
    void create() {
        // given
        Point point = new Point(false, false);

        // when
        assertThat(point).isEqualTo(new Point(false, false));
    }

    @Test
    @DisplayName("first 포인트 생성")
    void first() {
        Point point = Point.first(true);
        assertThat(point).isEqualTo(new Point(false, true));
    }

    @Test
    @DisplayName("다음 포인트 생성")
    void next() {
        Point first = Point.first(false);
        Point next = first.next(() -> true);

        assertThat(next).isEqualTo(new Point(false, true));
    }

    @Test
    @DisplayName("다음 포인트 생성 - 오른쪽 true")
    void nextRightTrue() {
        Point first = Point.first(true);
        Point next = first.next(() -> true);

        assertThat(next).isEqualTo(new Point(true, false));
    }

    @Test
    @DisplayName("last 포인트 생성")
    void last() {
        Point first = Point.first(true);
        Point last = first.last();
        assertThat(last).isEqualTo(new Point(true, false));
    }

    @ParameterizedTest
    @CsvSource(value = {"true, false, -1", "false, true, 1", "false, false, 0"}, delimiter = ',')
    @DisplayName("move로 이동 확인")
    void move(boolean left, boolean right, int expected) {
        // given
        Point first = Point.first(left);
        Point next = first.next(() -> right);
        Point last = next.last();

        // when
        int actual = next.move();

        assertThat(actual).isEqualTo(expected);
    }
}