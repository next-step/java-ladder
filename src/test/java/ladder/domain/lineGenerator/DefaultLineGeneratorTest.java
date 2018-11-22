package ladder.domain.lineGenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ladder.domain.Line;
import ladder.domain.LineGenerator;
import ladder.domain.Point;

public class DefaultLineGeneratorTest {

    @Test
    public void 라인_생성() {
        LineGenerator lineGenerator =  (count) -> { return createLine(); };
        assertThat(lineGenerator.generator(3).getPoints()).isEqualTo(createLine().getPoints());
    }

    public static Line createLine() {
        Line line = new Line();
        line.addPoint(Point.of(false, true));
        line.addPoint(Point.of(true, false));
        line.addPoint(Point.of(false, false));
        return line;
    }
}
