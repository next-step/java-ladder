package ladder;

import ladder.domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 라인_생성() {
        Line line = new Line(5);
        Assertions.assertThat(line.getLine().size()).isEqualTo(5);
    }
}
