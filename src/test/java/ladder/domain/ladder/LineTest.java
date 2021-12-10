package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("인원별로 포인트를 가지는 라인 생성")
    void create() {
        int players = 4;
        Line line = new Line(players, new RandomLadder());
        assertThat(line.getPoints()).size().isEqualTo(4);
    }

}