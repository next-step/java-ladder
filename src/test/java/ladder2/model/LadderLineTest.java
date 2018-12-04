package ladder2.model;

import org.junit.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    public static final LadderLine DEFAULT_LINE = new LadderLine(Arrays.asList(
            new Point(0, Direction.from(false, false)),
            new Point(1, Direction.from(false, true)),
            new Point(2, Direction.from(true, false)),
            new Point(3, Direction.from(false, false))));

    @Test
    public void 생성() {
        assertThat(LadderLine.from(5)).isNotNull();
    }
}