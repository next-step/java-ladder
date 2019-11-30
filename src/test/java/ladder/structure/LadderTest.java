package ladder.structure;

import ladder.structure.connection.RandomMove;
import ladder.structure.connection.result.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.structure.connection.result.Direction.RIGHT;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(4, 5, new RandomMove());
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        for (LineOfLadder line : lines) {
            List<Point> points = line.getPoints();
            for (int i = 0; i < points.size() - 1; i++) {
                if (points.get(i).getDirection() == RIGHT) {
                    System.out.print("----|");
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
        }
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder2() {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        for (LineOfLadder line : lines) {
            List<Point> points = line.getPoints();
            for (Point point : points) {
                if (point.getDirection() == RIGHT) {
                    System.out.print("----|");
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
        }
    }

//    @Test
//    @DisplayName("사다리 게임의 포인트 이동 확인")
//    void getLadderPoints() {
//        Ladder emptyLadder = new Ladder(2, 3, new NoneMove());
//        List<Point> finalPointsForEmptyLadder = emptyLadder.getFinalPoints().getPoints();
//        assertAll(
//                () -> assertThat(finalPointsForEmptyLadder.get(0)).isEqualTo(Point.of(0)),
//                () -> assertThat(finalPointsForEmptyLadder.get(1)).isEqualTo(Point.of(1))
//        );
//
//        Ladder allLadder = new Ladder(3, 3, new DefaultMove());
//        List<Point> finalPointsForAllLadder = allLadder.getFinalPoints().getPoints();
//        assertAll(
//                () -> assertThat(finalPointsForAllLadder.get(0)).isEqualTo(Point.of(1)),
//                () -> assertThat(finalPointsForAllLadder.get(1)).isEqualTo(Point.of(0)),
//                () -> assertThat(finalPointsForAllLadder.get(2)).isEqualTo(Point.of(2))
//        );
//    }
}
