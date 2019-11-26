package ladder.game;

import ladder.structure.Connection;
import ladder.structure.Ladder;
import ladder.structure.connection.DefaultConnection;
import ladder.structure.connection.NoneConnection;
import ladder.structure.connection.RandomConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {
    private Ladder ladder;
    private int personCount = 4;
    private int ladderHeight = 5;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(personCount, ladderHeight, new RandomConnection());
    }

    @Test
    @DisplayName("연속된 두 칸 모두 사다리가 그려질 수 업다")
    void verifiedLadderTest() {
        List<Connection> firstLineConnections = ladder.getLine(0).getConnections();
        assertThat(firstLineConnections.get(0).isConnected() ^ firstLineConnections.get(1).isConnected()
                || !firstLineConnections.get(0).isConnected())
                .isTrue();
        List<Connection> secondLineConnections = ladder.getLine(1).getConnections();
        assertThat(secondLineConnections.get(1).isConnected() ^ secondLineConnections.get(2).isConnected()
                || !secondLineConnections.get(1).isConnected())
                .isTrue();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        for (int lineIndex = 0; lineIndex < ladder.height(); lineIndex++) {
            List<Connection> line = ladder.getLine(lineIndex).getConnections();
            System.out.print("|");
            for (int i = 0; i < ladder.width(); i++) {
                boolean connection = line.get(i).isConnected();
                if (connection) {
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
