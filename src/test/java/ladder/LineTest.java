package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @DisplayName("참가자 수만큼 사다리 라인을 그리고 이동결과를 반환한다.")
    @Test
    void line_자동() {
        Players players = Players.of(Arrays.asList("kong", "dal", "apple", "red", "blue"));
        LineGenerator lineGenerator = new LineGenerator();
        Line ladderLine = lineGenerator.generate(players.count());

        assertThat(ladderLine.move(0) == 0 || ladderLine.move(0) == 1).isTrue();
        assertThat(ladderLine.move(4) == 3 || ladderLine.move(4) == 4).isTrue();
    }

    @DisplayName("포인트를 입력 받아 사다리 라인을 그리고 이동결과를 반환한다.")
    @Test
    void line() {
        int index = 0;
        Point point1 = new Point(index++, new Direction(false, true));
        Point point2 = new Point(index++, new Direction(true, false));
        Point point3 = new Point(index++, new Direction(false, true));
        Point point4 = new Point(index++, new Direction(true, false));
        Point point5 = new Point(index++, new Direction(false, false));

        Line ladderLine = new Line(Arrays.asList(point1, point2, point3, point4, point5));

        assertThat(ladderLine.move(0)).isEqualTo(1);
        assertThat(ladderLine.move(2)).isEqualTo(3);
        assertThat(ladderLine.move(4)).isEqualTo(4);
    }
}
