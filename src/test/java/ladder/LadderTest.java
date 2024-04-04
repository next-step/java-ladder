package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("플레이어 수와 높이에 따라 사다리를 생성한다.")
    void Ladder() {
        final Line line = new Line(List.of(true, false, true, false, true));
        final Ladder expectedLadder = new Ladder(List.of(line, line, line));

        final Ladder actualLadder = Ladder.from(new PlayersCount(5), new Height(3), () -> true);

        assertThat(actualLadder).isEqualTo(expectedLadder);
    }
}
