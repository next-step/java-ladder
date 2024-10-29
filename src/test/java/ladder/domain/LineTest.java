package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("플레이어 수보다 1개 작은 갯수의 가로선 포인트를 생성할 수 있다.")
    @Test
    void lineCreateTest() {
        int numberOfPlayers = 4;
        Line line = Line.of(numberOfPlayers, new RandomLineGenerator());

        assertThat(line.points()).hasSize(numberOfPlayers - 1);
    }

    @DisplayName("왼쪽 사다리로 건너간다.")
    @Test
    void testMoveLeft() {
        Line line = Line.of(List.of(true, false, false));

        assertThat(line.move(1)).isEqualTo(0);
    }

    @DisplayName("오른쪽 사다리로 건너간다.")
    @Test
    void testMoveRight() {
        Line line = Line.of(List.of(false, true, false));

        assertThat(line.move(1)).isEqualTo(2);
    }

    @DisplayName("현재 사다리에 머문다.")
    @Test
    void testMoveStraight() {
        Line line = Line.of(List.of(false, false, false));

        assertThat(line.move(1)).isEqualTo(1);
    }
}