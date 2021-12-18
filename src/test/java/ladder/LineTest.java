package ladder;

import ladder.domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("라인 생성")
    void createLine() {
        Line line = new Line(5);
        Assertions.assertThat(line.getPoints().size()).isEqualTo(5);
    }
}
