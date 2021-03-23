package ladder;

import ladder.domain.Direction;
import ladder.domain.Line;
import ladder.domain.LineList;
import ladder.domain.Position;
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
    @DisplayName("finalPosition 사다리타기 실행후 결과 테스트")
    void finalPosition() {
        LineList lineList = new LineList();
        lineList.add(Arrays.asList(Direction.of(false, false), Direction.of(false, true), Direction.of(true, false), Direction.of(false, false)));
        lineList.add(Arrays.asList(Direction.of(false, true), Direction.of(true, false), Direction.of(false, true), Direction.of(true, false)));
        lineList.add(Arrays.asList(Direction.of(false, true), Direction.of(true, false), Direction.of(false, false), Direction.of(false, false)));

        assertThat(lineList.finalPosition(new Position(0))).isEqualTo(new Position(0));
        assertThat(lineList.finalPosition(new Position(1))).isEqualTo(new Position(3));
        assertThat(lineList.finalPosition(new Position(2))).isEqualTo(new Position(1));
        assertThat(lineList.finalPosition(new Position(3))).isEqualTo(new Position(2));
    }


}
