package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void createTest() {
        Point intToPoint = Point.of(1);
        Point pointToPoint = Point.of(intToPoint);
        assertThat(intToPoint).isEqualTo(pointToPoint);
        assertThat(intToPoint).isEqualTo(intToPoint);
    }

    @DisplayName("left() 호출 시 위치 값을 -1 한다.")
    @Test
    void left() {
        Point point = Point.of(1);

        assertThat(point.left()).isEqualTo(Point.of(0));
    }

    @DisplayName("right() 호출 시 위치 값을 +1 한다.")
    @Test
    void right() {
        Point point = Point.of(1);

        assertThat(point.right()).isEqualTo(Point.of(2));
    }

}
