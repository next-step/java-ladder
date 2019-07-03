package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 사다리의_한_열을_생성한다() {
        List<Boolean> bars = Arrays.asList(true, false, false);
        Line line = new Line(bars);

        assertThat(line.getBars().get(0)).isTrue();
    }
}
