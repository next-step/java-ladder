package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point는 true, false 값을 가질 수 있다.")
    void createPoint() {
        assertThat(Point.first().middle()).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("Point의 첫번째 포인트는 left는 무조건 false이다.")
    void leftOfFirstPointShouldBeFalse() {
        assertThat(Point.first().isLeft()).isFalse();
    }

    @Test
    @DisplayName("Point의 마지막 포인트는 right는 무조건 false이다.")
    void rightOfLastPointShouldBeFalse() {
        assertThat(Point.first().last().isRight()).isFalse();
    }

}
