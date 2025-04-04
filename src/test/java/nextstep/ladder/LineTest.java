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
}
