package ladder.domain.ladder;

import ladder.strategy.RandomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("인원별로 포인트를 가지는 라인 생성")
    void create() {
        int players = 4;
        Line line = Line.createLine(players, new RandomLine());
        assertThat(line.getLiens()).size().isEqualTo(4);
    }

    @Test
    @DisplayName("라인에서 move(위치값) 호출 -> 위치값 계산 후 반환(+1)")
    void moveRight() {
        Line line = Line.createLine(4, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("라인에서 move(위치값) 호출 -> 위치값 계산 후 반환(-1)")
    void moveLeft() {
        Line line = Line.createLine(4, () -> true);
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("라인에서 move(위치값) 호출 -> 위치값 계산 후 반환(정지)")
    void notMove() {
        Line line = Line.createLine(4, () -> false);
        assertThat(line.move(1)).isEqualTo(1);
    }

}