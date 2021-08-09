package nextstep.ladder;

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
        int invalidHeightInteger = 0;
        ColumnLine columnLine = new ColumnLine(new Height(heightInteger));
        assertThat(columnLine.getPoints().size()).isEqualTo(heightInteger);
        assertThatThrownBy(() -> {
            new ColumnLine(new Height(invalidHeightInteger));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성")
    void createLadderTest() {
        List<Boolean> points1 = Arrays.asList(true,false,true);
        List<Boolean> points2 = Arrays.asList(true,true,true);
        List<ColumnLine> columnLines = Arrays.asList(new ColumnLine(points1), new ColumnLine(points2));
        Ladder ladder = new Ladder(columnLines);
        assertThat(ladder.getLines()).isEqualTo(columnLines);
    }
}
