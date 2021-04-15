package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineResultsTest {
    @DisplayName("포인트를 입력 받아 사다리 라인을 그리고 이동결과를 반환한다.")
    @Test
    void arrival() {
        Players players = Players.of(Arrays.asList("1", "2", "3"));

        int index = 0;
        PointNew pointNew1 = new PointNew(index++, new DirectionNew(false, true));
        PointNew pointNew2 = new PointNew(index++, new DirectionNew(true, false));
        PointNew pointNew3 = new PointNew(index++, new DirectionNew(false, false));

        Line ladderLine1 = new Line(Arrays.asList(pointNew1, pointNew2, pointNew3));

        index = 0;
        PointNew pointNew4 = new PointNew(index++, new DirectionNew(false, false));
        PointNew pointNew5 = new PointNew(index++, new DirectionNew(false, true));
        PointNew pointNew6 = new PointNew(index++, new DirectionNew(true, false));

        Line ladderLine2 = new Line(Arrays.asList(pointNew4, pointNew5, pointNew6));

        LineResults lineResults = new LineResults();
        lineResults.add(ladderLine1);
        lineResults.add(ladderLine2);

        assertThat(players.playerName(lineResults.arrivalPoint(0, 0))).isEqualTo("3");
        assertThat(players.playerName(lineResults.arrivalPoint(0, 1))).isEqualTo("1");
        assertThat(players.playerName(lineResults.arrivalPoint(0, 2))).isEqualTo("2");
    }
}
