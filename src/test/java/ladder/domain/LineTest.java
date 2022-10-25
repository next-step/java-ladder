package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    public void Line_생성() {
        Line line = Line.of(4);
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}