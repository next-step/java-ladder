package laddergameRDD.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergameRDD.common.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointTest {
    @DisplayName("사다리 한 점의 양 옆에 가로 선이 있을 경우 에러")
    @Test
    void create_point_error() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Point(true, true)
        );
    }

    @DisplayName("첫번째 point의 이전 값은 늘 false")
    @Test
    void create_first_point() {
        assertThat(Point.first(true).getPoint()).isEqualTo(false);
    }


    @DisplayName("마지막 point의 현재 값은 늘 false")
    @Test
    void create_end_point() {
        Point point = Point.first(true);
        assertThat(point.end())
                .extracting("current")
                .isEqualTo(false);
    }

    @DisplayName("사다리 한 점에서 오른쪽 이동")
    @Test
    void move_right() {
        assertThat(new Point(false, true).move()).isEqualTo(RIGHT);
    }

    @DisplayName("사다리 한 점에서 왼쪽 이동")
    @Test
    void move_left() {
        assertThat(new Point(true, false).move()).isEqualTo(LEFT);
    }

    @DisplayName("사다리 한 점에서 아래 이동")
    @Test
    void move_down() {
        assertThat(new Point(false, false).move()).isEqualTo(DOWN);
    }
}
