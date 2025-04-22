package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 라인_이동_테스트() {
        Line line = new Line(List.of(
                new LinePoint(0, Point.first(false).next(true)),
                new LinePoint(1, Point.first(true).next(false)),
                new LinePoint(2, Point.first(false).last())
        ));

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
