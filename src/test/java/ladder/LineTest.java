package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 연속으로_연결하면_안됨() {
        assertThat(new Line(2).getPoints()).isNotEqualTo(Arrays.asList(new Point(true), new Point(true)));
    }
}
