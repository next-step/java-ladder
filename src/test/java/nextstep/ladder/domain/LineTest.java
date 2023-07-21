package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 라인_출력() {
        List<Point> points = List.of(
                new Point(false), new Point(false), new Point(true), new Point(false), new Point(true));

        Line line = new Line(5, countOfPlayer -> points);

        String result = line.toString();

        assertThat(result).isEqualTo("      |      |------|      |------|");
    }
}
