package ladder;

import ladder.domain.DirectionNew;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.PointNew;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @DisplayName("참가자 수만큼 사다리 라인을 그리고 이동결과를 반환한다.")
    @Test
    void line_자동() {
        Players players = Players.of(Arrays.asList("kong", "dal", "apple", "red", "blue"));
        Line ladderLine = new Line(players.count());

        assertThat(ladderLine.move(0) == 0 || ladderLine.move(0) == 1).isTrue();
        assertThat(ladderLine.move(4) == 3 || ladderLine.move(4) == 4).isTrue();
    }

    @DisplayName("포인트를 입력 받아 사다리 라인을 그리고 이동결과를 반환한다.")
    @Test
    void line() {
        int index = 0;
        PointNew pointNew1 = new PointNew(index++, new DirectionNew(false, true));
        PointNew pointNew2 = new PointNew(index++, new DirectionNew(true, false));
        PointNew pointNew3 = new PointNew(index++, new DirectionNew(false, true));
        PointNew pointNew4 = new PointNew(index++, new DirectionNew(true, false));
        PointNew pointNew5 = new PointNew(index++, new DirectionNew(false, false));

        Line ladderLine = new Line(Arrays.asList(pointNew1, pointNew2, pointNew3, pointNew4, pointNew5));

        assertThat(ladderLine.move(0)).isEqualTo(1);
        assertThat(ladderLine.move(2)).isEqualTo(3);
        assertThat(ladderLine.move(4)).isEqualTo(4);
    }
}
