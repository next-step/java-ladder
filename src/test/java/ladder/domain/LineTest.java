package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("플레이어 수보다 1개 작은 갯수의 가로선 포인트를 생성할 수 있다.")
    @Test
    void lineCreateTest() {
        int numberOfPlayers = 4;
        Line line = new Line(numberOfPlayers, new RandomLineGenerator());

        assertThat(line.points()).hasSize(numberOfPlayers - 1);
    }
}