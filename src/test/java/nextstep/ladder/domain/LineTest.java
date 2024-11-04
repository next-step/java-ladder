package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LineTest {

    @Test
    @DisplayName("특정 라인의 position에 진입하면 다음 position을 반환한다.")
    void move() {
        List<Point> points = new ArrayList<>(
                List.of(new Point(false, true),
                        new Point(true, false),
                        new Point(false, false)));
        Line line = new Line(points);
        Assertions.assertThat(line.move(0)).isEqualTo(1);
        Assertions.assertThat(line.move(1)).isEqualTo(0);
        Assertions.assertThat(line.move(2)).isEqualTo(2);
    }
}
