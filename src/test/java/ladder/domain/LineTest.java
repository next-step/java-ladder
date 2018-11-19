package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class LineTest {

    @Test(expected = IllegalArgumentException.class)
    public void 가로라인_겹칠때_검증() {
        Line line = new Line(2);
        line.addPoint(Point.of(false, true));
        line.addPoint(Point.of(true, true));
    }

    @Test
    public void 가로라인_겹치지않을때_검증() {
        Line line = new Line(2);
        line.addPoint(Point.of(false, true));
        line.addPoint(Point.of(true, false));
        assertThat(line.getPoints()).isEqualTo(Arrays.asList(Point.of(false, true), Point.of(true, false)));
    }
    
    @Test(expected = IllegalStateException.class)
    public void 참가자수이상_라인그을때() {
        Line line = new Line(2);
        line.addPoint(Point.of(true, false));
        line.addPoint(Point.of(false, true));
        line.addPoint(Point.of(true, false));
    }
}
