package ladder;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private Lines lines;

    @BeforeEach
    void setUp() {
        String input = "tom,base,yeahs";
        lines = new Lines(5, input);

        List<Point> points = Arrays.asList(new Point(Boolean.FALSE), new Point(Boolean.TRUE),
                new Point(Boolean.FALSE), new Point(Boolean.FALSE));
        Line line  = new Line(points);
    }

    @Test
    void linesTest() {
        assertThat(lines.getLadderLines()).hasSize(5);
    }

    @Test
    void linesWithParameterTest() {
        String input = "a,b,c,iron_man";
        Lines lines1 = new Lines(5, input);
        assertThat(lines1.getLadderLines()).hasSize(5);
        assertThat(lines1.getPeople()).contains("a", "b", "c");
    }
}
