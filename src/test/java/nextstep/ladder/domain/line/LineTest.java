package nextstep.ladder.domain.line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void create() {
        int pointCount = 4;
        Line line = new Line(pointCount);

        Assertions.assertThat(line).isNotNull();
    }
}