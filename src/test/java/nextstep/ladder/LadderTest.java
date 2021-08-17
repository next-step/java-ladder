package nextstep.ladder;

import nextstep.ladder.application.CreatePointStrategy;
import nextstep.ladder.domain.ladder.ColumnLine;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("사다리 라인 생성")
    void createLineTest() {
        int heightInteger = 5;
        ColumnLine columnLine = new ColumnLine(new Height(heightInteger));
        assertThat(columnLine.getPoints().size()).isEqualTo(heightInteger);
    }

    @Test
    @DisplayName("사다리 라인 에러")
    void createLineExceptionTest() {
        int invalidHeightInteger = 0;
        assertThatThrownBy(() -> {
            new ColumnLine(new Height(invalidHeightInteger));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성")
    void createLadderTest(){
        ColumnLine line1 = new ColumnLine(new Height(3));
        ColumnLine line2 = new ColumnLine(new Height(3));
        ColumnLine line3 = new ColumnLine(new Height(3));

        line1.drawRowLine(line2, 0, () -> false);
        line2.drawRowLine(line3, 0, () -> true);

        line1.drawRowLine(line2, 1, () -> true);
        line2.drawRowLine(line3, 1, () -> false);

        line1.drawRowLine(line2, 2, () -> true);
        line2.drawRowLine(line3, 2, () -> false);

        List<ColumnLine> columnLines = Arrays.asList(line1,line2,line3);
        Ladder ladder = new Ladder(columnLines);

        List<Boolean> points1 = Arrays.asList(false,true,true);
        List<Boolean> points2 = Arrays.asList(true,true,true);
        List<Boolean> points3 = Arrays.asList(true,false,false);

        List<ColumnLine> compareColumnLines = Arrays.asList(new ColumnLine(points1), new ColumnLine(points2), new ColumnLine(points3));
        Ladder compareLadder = new Ladder(compareColumnLines);

        assertThat(ladder.getLines()).isEqualTo(compareLadder.getLines());
    }


}
