package nextstep.ladder;

import nextstep.ladder.application.PlayLadder;
import nextstep.ladder.domain.ladder.ColumnLine;
import nextstep.ladder.domain.ladder.Direction;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    Ladder compareLadder;

    @BeforeEach
    void setup() {
        ColumnLine compareLine1 = new ColumnLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.RIGHT));
        ColumnLine compareLine2 = new ColumnLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.LEFT));
        ColumnLine compareLine3 = new ColumnLine(Arrays.asList(Direction.LEFT, Direction.NONE, Direction.NONE));

        List<ColumnLine> compareColumnLines = Arrays.asList(compareLine1, compareLine2, compareLine3);
        compareLadder = new Ladder(compareColumnLines);
    }

    @Test
    @DisplayName("사다리 생성")
    void createLadderTest() {
        ColumnLine line1 = new ColumnLine(new Height(3));
        ColumnLine line2 = new ColumnLine(new Height(3));
        ColumnLine line3 = new ColumnLine(new Height(3));

        line1.getPointOfHeight(0)
                .drawRightLine(line2.getPointOfHeight(0), () -> false);
        line2.getPointOfHeight(0)
                .drawRightLine(line3.getPointOfHeight(0), () -> true);

        line1.getPointOfHeight(1)
                .drawRightLine(line2.getPointOfHeight(1), () -> true);
        line2.getPointOfHeight(1)
                .drawRightLine(line3.getPointOfHeight(1), () -> false);

        line1.getPointOfHeight(2)
                .drawRightLine(line2.getPointOfHeight(2), () -> true);
        line2.getPointOfHeight(2)
                .drawRightLine(line3.getPointOfHeight(2), () -> false);

        List<ColumnLine> columnLines = Arrays.asList(line1,line2,line3);
        Ladder ladder = new Ladder(columnLines);

        assertThat(ladder).isEqualTo(compareLadder);
    }

    @Test
    @DisplayName("사다리 생성, 결과값 포함")
    void createLadderWithResultsTest() {
        List<ColumnLine> columnLines = PlayLadder.createColumnLines(3, 3, Arrays.asList("꽝", "1000", "꽝"));

        ColumnLine compareLine1 = new ColumnLine(new Height(3),"꽝");
        ColumnLine compareLine2 = new ColumnLine(new Height(3),"1000");
        ColumnLine compareLine3 = new ColumnLine(new Height(3),"꽝");

        List<ColumnLine> compareColumnLines = Arrays.asList(compareLine1, compareLine2, compareLine3);

        Ladder ladder = new Ladder(columnLines);
        Ladder compareWithResultLadder = new Ladder(compareColumnLines);

        assertThat(ladder).isEqualTo(compareWithResultLadder);
    }

    @Test
    @DisplayName("사다리 생성 결과값 에러 테스트")
    void inputResultsExceptionTest() {
        assertThatThrownBy(() -> {
            PlayLadder.playLadder(Arrays.asList("aa", "bb", "cc"), 3, Arrays.asList("꽝", "1000"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
