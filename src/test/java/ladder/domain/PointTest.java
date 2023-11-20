package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("boolean 값에 따라 포인트가 생성된다.")
    void createPoint() {
        boolean inputPoint = true;
        Point point = new Point(inputPoint);

        assertThat(point).isEqualTo(new Point(inputPoint));
    }

    @Test
    @DisplayName("이전 Point의 상태가 true 였다면 false로 point를 생성한다.")
    void nextPoint() {
        boolean inputPoint = true;
        Point point = new Point(inputPoint);

        assertThat(point.nextPoint(() -> true)).isEqualTo(new Point(false));
    }

    @Test
    @DisplayName("이전 Point의 상태가 false 였다면 랜덤으로 나오는 boolean값으로 point를 생성한다.")
    void nextPoint_random() {
        boolean inputPoint = false;
        Point point = new Point(inputPoint);

        assertThat(point.nextPoint(() -> true)).isEqualTo(new Point(true));
    }
}