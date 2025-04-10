package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("이전 Point가 RIGHT면 현재 Point는 LEFT이다")
    void previousPointIsRightThenCurrentPointIsLeft() {
        Line line = Line.generate(2, () -> Point.RIGHT);
        Assertions.assertThat(line.getPoints().get(0)).isEqualTo(Point.RIGHT);
        Assertions.assertThat(line.getPoints().get(1)).isEqualTo(Point.LEFT);
    }

    @Test
    @DisplayName("마지막 줄의 이전 Point가 LEFT면 마지막 줄 Point는 NONE이다")
    void lastLinePreviousPointIsLeftThenCurrentPointIsNone() {
        Line line = Line.generate(2, () -> Point.LEFT);
        Assertions.assertThat(line.getPoints().get(0)).isEqualTo(Point.LEFT);
        Assertions.assertThat(line.getPoints().get(1)).isEqualTo(Point.NONE);
    }

    @Test
    @DisplayName("마지막 줄의 이전 Point가 NONE면 마지막 줄 Point는 NONE이다")
    void lastLinePreviousPointIsNoneThenCurrentPointIsNone() {
        Line line = Line.generate(2, () -> Point.NONE);
        Assertions.assertThat(line.getPoints().get(0)).isEqualTo(Point.NONE);
        Assertions.assertThat(line.getPoints().get(1)).isEqualTo(Point.NONE);
    }

    @Test
    @DisplayName("마지막 줄의 이전 Point가 RIGHT면 마지막 줄 Point는 LEFT이다")
    void lastLinePreviousPointIsRightThenCurrentPointIsLeft() {
        Line line = Line.generate(2, () -> Point.RIGHT);
        Assertions.assertThat(line.getPoints().get(0)).isEqualTo(Point.RIGHT);
        Assertions.assertThat(line.getPoints().get(1)).isEqualTo(Point.LEFT);
    }
}
