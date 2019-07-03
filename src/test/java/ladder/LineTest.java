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

    @Test
    void 플레이어_수_마이너스_1_만큼_바를_랜덤으로_생성한다() {
        int numberOfPlayers = 5;
        Line line = Line.from(numberOfPlayers);

        assertThat(line.getBars().size()).isEqualTo(numberOfPlayers - 1);
    }
}
