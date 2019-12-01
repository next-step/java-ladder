package ladder.structure;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.result.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static final String VERTICAL = "|";
    private static final String HORIZON = "-----";
    private static final String EMPTY_HORIZON = "     ";
    private MoveStrategy moveStrategy = new DefaultMove();
    private Ladder ladder = new Ladder(5, 5, moveStrategy);
    private List<Integer> finalPoints = ladder.getFinalPoints();

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    @DisplayName("결과값 확인")
    void getFinalPoints(int start, int result) {
        assertThat(finalPoints.get(start)).isEqualTo(result);
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder2() {
        List<LineOfLadder> lines = ladder.getLines();
        for (LineOfLadder line : lines) {
            List<Point> points = line.getPoints();
            for (Point point : points) {
                System.out.print((point.isRightOpened() ? HORIZON : EMPTY_HORIZON)
                        + VERTICAL);
            }
            System.out.println();
        }
    }
}