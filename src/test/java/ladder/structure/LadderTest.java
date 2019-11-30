package ladder.structure;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.NoneMove;
import ladder.structure.connection.RandomMove;
import ladder.structure.connection.result.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ladder.structure.connection.result.Direction.RIGHT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(4, 5, new RandomMove());
    }

    @Test
    @DisplayName("연속된 두 칸 모두 사다리가 그려질 수 업다")
    void verifiedLadderTest() {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        Map<Integer, Point> firstLine = lines.get(0).getPoints().getPoints().stream()
                .collect(Collectors.toMap(Point::getColumn, point -> point));
        assertThat(firstLine.get(0).getDirection() == RIGHT
                && firstLine.get(1).getDirection() == RIGHT)
                .isFalse();

        Map<Integer, Point> secondLine = lines.get(1).getPoints().getPoints().stream()
                .collect(Collectors.toMap(Point::getColumn, point -> point));
        assertThat(secondLine.get(0).getDirection() == RIGHT &&
                secondLine.get(1).getDirection() == RIGHT)
                .isFalse();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        for (LineOfLadder line : lines) {
            Map<Integer, Point> lineIndexWithPoint = line.getPoints().getPoints().stream()
                    .collect(Collectors.toMap(Point::getColumn, point -> point));
            for (int i = 0; i < lineIndexWithPoint.size() - 1; i++) {
                if (lineIndexWithPoint.get(i).getDirection() == RIGHT) {
                    System.out.print("----|");
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
        }
    }

    @Test
    @DisplayName("사다리 게임의 포인트 이동 확인")
    void getLadderPoints() {
        Ladder emptyLadder = new Ladder(2, 3, new NoneMove());
        List<Point> finalPointsForEmptyLadder = emptyLadder.getFinalPoints().getPoints();
        assertAll(
                () -> assertThat(finalPointsForEmptyLadder.get(0)).isEqualTo(Point.of(0)),
                () -> assertThat(finalPointsForEmptyLadder.get(1)).isEqualTo(Point.of(1))
        );

        Ladder allLadder = new Ladder(3, 3, new DefaultMove());
        List<Point> finalPointsForAllLadder = allLadder.getFinalPoints().getPoints();
        assertAll(
                () -> assertThat(finalPointsForAllLadder.get(0)).isEqualTo(Point.of(1)),
                () -> assertThat(finalPointsForAllLadder.get(1)).isEqualTo(Point.of(0)),
                () -> assertThat(finalPointsForAllLadder.get(2)).isEqualTo(Point.of(2))
        );
    }
}
