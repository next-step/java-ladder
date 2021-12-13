package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("포인트 객체 생성")
    void create() {
        Point point = new Point();
        assertThat(point).isEqualTo(new Point());
    }

    @Test
    @DisplayName("방향값 right - true 인지 확인")
    void isRight() {
        Point point = new Point(0, new PointDirection(false, true));
        assertThat(point.isRight()).isTrue();
    }

    @Test
    @DisplayName("포인트 방향값 right(true) - 위치값 +1 증가")
    void moveRight() {
        Point point = new Point(1, new PointDirection(false, true));
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("포인트 방향값 left(true) - 위치값 -1 감소")
    void moveLeft() {
        Point point = new Point(2, new PointDirection(true, false));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("포인트 방향값 left(false),right(false) - 위치값 그대로")
    void moveStop() {
        Point point = new Point(1, new PointDirection(false, false));
        assertThat(point.move()).isEqualTo(1);
    }

}
