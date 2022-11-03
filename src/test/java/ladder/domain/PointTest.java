package ladder.domain;

import static ladder.domain.line.BarHelper.getBars;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import ladder.domain.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("주어진 라인에 대해 시작 위치에 따라 이동되는 위치 테스트")
    void move() {
        Line line = new Line(6, getBars(List.of(false, true, false, true, false, false)));
        assertAll(
                () -> assertThat(movePoint(0, line)).isEqualTo(1),
                () -> assertThat(movePoint(1, line)).isEqualTo(0),
                () -> assertThat(movePoint(2, line)).isEqualTo(3),
                () -> assertThat(movePoint(3, line)).isEqualTo(2),
                () -> assertThat(movePoint(4, line)).isEqualTo(4),
                () -> assertThat(movePoint(5, line)).isEqualTo(5)
        );
    }

    private int movePoint(int startIndex, Line line) {
        Point point = new Point(startIndex);
        point.move(line);
        return point.getIndex();
    }
}