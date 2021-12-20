package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void 위치_이동() {
        Point point = Point.first(() -> true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void 첫번째_위치_생성() {
        Point first = Point.first(() -> true);
        assertThat(first).isEqualTo(new Point(0, new Direction(false, true)));
    }

    @Test
    void 다음_위치_생성_이전_위치가_선이_있을_경우() {
        Point next = Point.first(() -> true).next(() -> false);
        assertThat(next).isEqualTo(new Point(1, new Direction(true, false)));
    }

    @Test
    void 다음_위치_생성_이전_위치가_선이_없을_경우() {
        Point next = Point.first(() -> false).next(() -> true);
        assertThat(next).isEqualTo(new Point(1, new Direction(false, true)));
    }

    @Test
    void 마지막_위치_생성() {
        Point last = Point.first(() -> true).next(() -> false).last();
        assertThat(last).isEqualTo(new Point(2, new Direction(false, false)));
    }
}