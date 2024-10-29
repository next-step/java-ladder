package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LineTest {

    @Test
    void 해당위치에_다리가_있는지_판단한다() {
        List<Point> points = Arrays.asList(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false));
        Line line = new Line(points);
        Assertions.assertThat(line.hasBridgeAtPosition(0)).isTrue();
        Assertions.assertThat(line.hasBridgeAtPosition(1)).isTrue();
        Assertions.assertThat(line.hasBridgeAtPosition(2)).isFalse();
    }

    @Test
    void 해당위치에_다리를_놓는다() {
        Line line = new Line(3);
        line.putBridgeAtPosition(0);
        Assertions.assertThat(line.hasBridgeAtPosition(0)).isTrue();
        Assertions.assertThat(line.hasBridgeAtPosition(1)).isTrue();
        Assertions.assertThat(line.hasBridgeAtPosition(2)).isFalse();
    }
}
