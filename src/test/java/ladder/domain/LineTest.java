package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인이 생긴 점을 제외하고 emptyPoints를 반환한다")
    void setAndEmpty() {
        Line line = new Line(5);
        line.setPoint(2, Point.LEFT);
        line.setPoint(3, Point.RIGHT);

        assertThat(line.emptyPoints()).containsExactly(0, 1, 4);
    }
}
