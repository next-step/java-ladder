package ladder;

import ladder.domain.LadderNumber;
import ladder.domain.Line;
import ladder.domain.LineList;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineListTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        int height = 5;
        int countOfPerson = 6;
        LineList lineList = LineList.of(height, countOfPerson);
        List<Line> rawLineList = lineList.lineList();

        assertThat(lineList.size()).isEqualTo(height);
        assertThat(rawLineList.get(0).pointListSize()).isEqualTo(countOfPerson);
    }

    @Test
    @DisplayName("endLadderNumber로 사다리타기 실행후 결과 테스트")
    void endLadderNumber() {
        LineList lineList = new LineList();
        lineList.add(Arrays.asList(new Point(false), new Point(false), new Point(true), new Point(false)));
        lineList.add(Arrays.asList(new Point(false), new Point(true), new Point(false), new Point(true)));
        lineList.add(Arrays.asList(new Point(false), new Point(true), new Point(false), new Point(false)));


        assertThat(lineList.endLadderNumber(new LadderNumber(0))).isEqualTo(new LadderNumber(0));
        assertThat(lineList.endLadderNumber(new LadderNumber(1))).isEqualTo(new LadderNumber(3));
        assertThat(lineList.endLadderNumber(new LadderNumber(2))).isEqualTo(new LadderNumber(1));
        assertThat(lineList.endLadderNumber(new LadderNumber(3))).isEqualTo(new LadderNumber(2));
    }


}
