package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LineTest {

    @Test
    void 해당_라인에_선이_존재해야한다() {
        Line line = new Line(Arrays.asList(false, false, false, false, false));
        Assertions.assertThat(line.hasLine()).isFalse();
    }

    @Test
    void 사다리_라인이_겹치지_않도록한다() {
        Line line = new Line(5);
    }
}
