package ladder.structure;

import ladder.structure.connection.Connection;
import ladder.structure.connection.DefaultConnection;
import ladder.structure.connection.NoneConnection;
import ladder.structure.connection.RandomConnection;
import ladder.structure.connection.result.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(4, 5, new RandomConnection());
    }

    @Test
    @DisplayName("연속된 두 칸 모두 사다리가 그려질 수 업다")
    void verifiedLadderTest() {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        List<Connection> firstLineConnections = lines.get(0).getConnections();
        assertThat(firstLineConnections.get(0).isConnected() && firstLineConnections.get(1).isConnected())
                .isFalse();
        List<Connection> secondLineConnections = lines.get(1).getConnections();
        assertThat(secondLineConnections.get(1).isConnected() && secondLineConnections.get(2).isConnected())
                .isFalse();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        for (LineOfLadder line : lines) {
            List<Connection> connections = line.getConnections();
            System.out.print("|");
            for (Connection connection : connections) {
                boolean isConnected = connection.isConnected();
                if (isConnected) {
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
        Ladder emptyLadder = new Ladder(2, 3, new NoneConnection());
        List<Point> finalPointsForEmptyLadder = emptyLadder.getFinalPoints().getPoints();
        assertAll(
                () -> assertThat(finalPointsForEmptyLadder.get(0)).isEqualTo(Point.of(0)),
                () -> assertThat(finalPointsForEmptyLadder.get(1)).isEqualTo(Point.of(1))
        );

        Ladder allLadder = new Ladder(3, 3, new DefaultConnection());
        List<Point> finalPointsForAllLadder = allLadder.getFinalPoints().getPoints();
        assertAll(
                () -> assertThat(finalPointsForAllLadder.get(0)).isEqualTo(Point.of(1)),
                () -> assertThat(finalPointsForAllLadder.get(1)).isEqualTo(Point.of(0)),
                () -> assertThat(finalPointsForAllLadder.get(2)).isEqualTo(Point.of(2))
        );
    }
}
