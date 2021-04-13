package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {
    @Test
    public void create() {
        final List<Point> points = Arrays.asList(Point.BEGIN, Point.END, Point.COMMON, Point.BEGIN, Point.END);

        assertThat(new LadderLine(points)).isEqualTo(new LadderLine(points));
    }

    @Test
    public void create_when_lastIsBegin() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final List<Point> points = Arrays.asList(Point.BEGIN, Point.END, Point.COMMON, Point.COMMON, Point.BEGIN);

            new LadderLine(points);
        });
    }

    @Test
    public void create_when_beginEndIsNotContinuous() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final List<Point> points = Arrays.asList(Point.BEGIN, Point.COMMON, Point.COMMON, Point.BEGIN, Point.END);

            new LadderLine(points);
        });
    }
}
