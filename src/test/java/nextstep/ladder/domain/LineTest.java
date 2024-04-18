package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    public void 라인수() {
        Line line = new Line(5);
        assertThat(line.getList().size()).isEqualTo(5);
    }
}