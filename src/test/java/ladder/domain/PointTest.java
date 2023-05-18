package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("가로라인 가장 왼쪽 포인트 생성")
    void first() {
        Point point = Point.first(true);
        assertThat(point).isEqualTo(new Point(false, true));
    }

    @Test
    @DisplayName("가로라인 중간 포인트 생성")
    void next() {
        Point first = Point.first(false);
        Point next = first.next(() -> true);

        assertThat(next).isEqualTo(new Point(false, true));
    }

    @Test
    @DisplayName("중간 포인트 생성 - 오른쪽 true")
    void nextRightTrue() {
        Point first = Point.first(true);
        Point next = first.next(() -> true);

        assertThat(next).isEqualTo(new Point(true, false));
    }

    @Test
    @DisplayName("가로라인 가장 오른쪽 포인트 생성")
    void last() {
        Point first = Point.first(true);
        Point last = first.last();
        assertThat(last).isEqualTo(new Point(true, false));
    }
}