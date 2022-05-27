package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LineTest {
    public static Line line1 = new Line(Arrays.asList(true, false, true, false));
    public static Line line2 = new Line(Arrays.asList(false, true, false, false));

    @Test
    void move() {
        Assertions.assertThat(line1.move(0)).isEqualTo(1);
        Assertions.assertThat(line2.move(0)).isEqualTo(0);
    }
}
