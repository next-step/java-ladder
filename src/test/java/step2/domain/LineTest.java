package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void removeDirection() {

        Line line = new Line(true);
        line.removeDirection(Pointer.RIGHT);

        assertThat(line.isStep()).isEqualTo(false);

    }
}
