package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void 해당_라인에_선이_존재해야한다() {
        Line line = new Line(Arrays.asList(false, false, false, false, false));
        assertThat(line.hasLine()).isFalse();
    }

    @Test
    void 사다리_라인이_겹치지_않도록한다() {
        Line line = new Line(Arrays.asList(false, false, false, false, false));
        assertThat(line.isLinesOverlap()).isFalse();

        Line line2 = new Line(Arrays.asList(false, false, false, true, true));
        assertThat(line2.isLinesOverlap()).isTrue();
    }
}
