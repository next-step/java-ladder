package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("사다리 가로선 위치 생성 테스트")
    @Test
    void create_point() {
        assertThat(new Point(true)).isEqualTo(new Point(true));
    }

    @DisplayName("이전 위치에 가로선이 있으면, 사다리 가로선은 생성이 안됨")
    @Test
    void do_not_create_horizontal_line() {
        Point point = new Point();
        point.selectPoint(new Point(true), ()->true);

        assertThat(point).isEqualTo(new Point(false));
    }

    @DisplayName("이전 위치에 가로선이 없으면, 사다리 가로선은 생성 됨")
    @Test
    void create_horizontal_line() {
        Point point = new Point();
        point.selectPoint(new Point(false), ()->true);

        assertThat(point).isEqualTo(new Point(true));
    }
}
