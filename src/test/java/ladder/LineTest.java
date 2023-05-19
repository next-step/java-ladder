package ladder;

import ladder.generator.RandomBooleanGenerator;
import ladder.model.Line;
import ladder.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineTest {
    @DisplayName("라인의 Point 수는 참여자수와 일치한다.")
    @Test
    void lineSize() {
        Line line = Line.create(3, new RandomBooleanGenerator());
        assertThat(line.size()).isEqualTo(3);
    }

    @DisplayName("라인의 각 포인트에서 이동한 결과를 계산할 수 있다.")
    @Test
    void move() {
        Line line = new Line(List.of(Point.createFirst(true), new Point(1, true, false)));
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    void createFail() {
        Point point1 = new Point(0, false, true);
        Point point2 = new Point(1, false, false);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Line(List.of(point1, point2)));
    }
}
