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
        Point point = new Point(0, new Direction(false, true));
        assertThat(point.isRight()).isTrue();
    }

    @Test
    @DisplayName("방향값 right - false")
    void isNotRight() {
        Point point = new Point(0, new Direction(false, false));
        assertThat(point.isRight()).isFalse();
    }

}
