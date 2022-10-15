package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("패스")
    void pass() {
        Point point = new Point(false, false);
        assertThat(point.move(1)).isEqualTo(1);
    }
}
