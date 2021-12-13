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
        Line line = new Line(players, new RandomLine());
        assertThat(line.getPoints()).size().isEqualTo(5);
    }

    @Test
    @DisplayName("포인트에 선이 있을 경우, 포인트 위치 값은 +1 움직인다")
    void move() {
        Line line = new Line(4, () -> true);
        System.out.println(line.getPoints());
        assertThat(line.move(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("포인트에 선이 없을 경우, 포인트는 위치 값은 정지")
    void notMove() {
        Line line = new Line(4, () -> false);
        System.out.println(line.getPoints());
        assertThat(line.move(1)).isEqualTo(1);
    }

}