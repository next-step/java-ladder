package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LineTest {

    @Test
    void 해당_라인에_선이_존재해야한다() {
        Line line = new Line(Arrays.asList(new Point(false), new Point(false), new Point(false), new Point(false), new Point(false)));
        Assertions.assertThat(line.hasLine()).isTrue();
    }
}
