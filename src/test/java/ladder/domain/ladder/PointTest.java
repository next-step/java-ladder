package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("포인트 객체 생성")
    void create() {
        Point point = Point.of(0, PointDirection.first(false, false));
        assertThat(point).isEqualTo(Point.of(0, PointDirection.first(false, false)));
    }

    @Test
    @DisplayName("첫번째 포인트 객체 생성 - 포지션(0), left - false")
    void first() {
        Point first = Point.first(true);
        assertThat(first).isEqualTo(Point.first(true));
        assertThat(first.getPosition()).isEqualTo(0);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("중간 포인트 객체 생성 - 포지션 +1, right - random")
    void middle() {
        Point first = Point.first(true);
        Point middle = Point.middle(first, true);
        assertThat(middle).isEqualTo(Point.middle(first, true));
        assertThat(middle.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("마지막 포인트 객체 생성 - 포지션 +1, right - false")
    void last() {
        Point first = Point.first(true);
        Point middle = Point.middle(first, true);
        Point last = Point.last(middle);
        assertThat(last).isEqualTo(Point.last(middle));
        assertThat(last.getPosition()).isEqualTo(2);
        assertThat(last.isRight()).isFalse();
    }

    @Test
    @DisplayName("포인트 방향값 right(true) - 위치값 +1 증가")
    void moveRight() {
        Point point = Point.of(1, PointDirection.of(false, true));
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("포인트 방향값 left(true) - 위치값 -1 감소")
    void moveLeft() {
        Point point = Point.of(2, PointDirection.of(true, false));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("포인트 방향값 left(false),right(false) - 위치값 그대로")
    void moveStop() {
        Point point = Point.of(1, PointDirection.of(false, false));
        assertThat(point.move()).isEqualTo(1);
    }

}
