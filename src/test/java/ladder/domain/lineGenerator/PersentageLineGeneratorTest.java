package ladder.domain.lineGenerator;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersentageLineGeneratorTest {

    @Test
    public void 백프로확률_선긋기() {
        PersentageLineGenerator lineGenerator = new PersentageLineGenerator(100);
        assertThat(lineGenerator.generator(4).getPoints()).isEqualTo(create100PercentLine().getPoints());
    }

    @Test
    public void 영프로확률_선긋기() {
        PersentageLineGenerator lineGenerator = new PersentageLineGenerator(0);
        assertThat(lineGenerator.generator(4).getPoints()).isEqualTo(create0PercentLine().getPoints());
    }

    private Line create0PercentLine() {
        Line line = new Line();
        line.addPoint(Point.of(false, false));
        line.addPoint(Point.of(false, false));
        line.addPoint(Point.of(false, false));
        line.addPoint(Point.of(false, false));
        return line;
    }

    public static Line create100PercentLine() {
        Line line = new Line();
        line.addPoint(Point.of(false, true));
        line.addPoint(Point.of(true, false));
        line.addPoint(Point.of(false, true));
        line.addPoint(Point.of(true, false));
        return line;
    }
}