package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void move() {
        Line line = new Line(Arrays.asList(true, false, true, false));
        Line line2 = new Line(Arrays.asList(false, false, false, false));
        Ladder ladder = new Ladder(Arrays.asList(line, line2));

        assertThat(ladder.move(0)).isEqualTo(1);
    }
}
