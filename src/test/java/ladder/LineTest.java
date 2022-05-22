package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void 해당_라인에_선이_존재해야한다() {
        Line line = new Line(Arrays.asList(new Point(false), new Point(false), new Point(false), new Point(false), new Point(false)));
        line.hasLine();
    }

    @Test
    void 사다리_라인이_겹치지_않도록한다() {

    }
}
