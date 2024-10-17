package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 생성() {
        Line line = new Line(2, new FixedLineGenerator());
        assertThat(line).isEqualTo(new Line(false, false));
    }
}
