package nextstep.ladder;

import nextstep.ladder.domain.ladder.ColumnLine;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
    @Test
    @DisplayName("사다리 라인 생성")
    void createLineTest() {
        int heightInteger = 5;
        int invalidHeightInteger = 0;
        ColumnLine columnLine = new ColumnLine(new Height(heightInteger));
        assertThat(columnLine.getHeight()).isEqualTo(heightInteger);
        assertThatThrownBy(() -> {
            new ColumnLine(new Height(invalidHeightInteger));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성")
    void createLadderTest() {
        int heightInteger = 3;
        List<Boolean> points1 = Arrays.asList(true,false,true);
        List<Boolean> points2 = Arrays.asList(true,true,true);
        List<ColumnLine> columnLines = Arrays.asList(new ColumnLine(new Height(heightInteger),points1), new ColumnLine(new Height(heightInteger),points2));
        Ladder ladder = new Ladder(columnLines);
        assertThat(ladder.getLines()).isEqualTo(columnLines);
    }

    @Test
    @DisplayName("사다리 라인 겹치지 않는지 확인")
    void ladderLineDupleTest() {
        int heightInteger = 3;
        int countOfPerson = 3;
        Ladder ladder = new Ladder(heightInteger,countOfPerson);
        for (int i = 1; i < ladder.getLines().size()-1; i++) {
            for (int j = 0; j < ladder.getLines().get(i).getPoints().size(); j++) {
                if(ladder.getLines().get(i).getPoints().get(j)) {
                    assertThat(ladder.getLines().get(i).getPoints().get(j) &&
                            ladder.getLines().get(i-1).getPoints().get(j) &&
                            ladder.getLines().get(i+1).getPoints().get(j))
                            .isFalse();
                }
            }
        }
    }
}
