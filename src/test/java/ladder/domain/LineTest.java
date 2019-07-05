package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 플레이어_수_만큼_바를_랜덤으로_생성한다() {
        int numberOfPlayers = 5;
        Line line = Line.from(numberOfPlayers);

        assertThat(line.getBars().size()).isEqualTo(numberOfPlayers);
    }
}
