package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.LineOfLadder;
import ladder.structure.connection.DefaultConnection;
import ladder.structure.connection.NoneConnection;
import ladder.structure.connection.RandomConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        LineOfLadder firstLine = ladder.getLine(0);
        assertThat(firstLine.getConnection(0) ^ firstLine.getConnection(1)
                || !firstLine.getConnection(0))
                .isTrue();
        LineOfLadder secondLine = ladder.getLine(1);
        assertThat(secondLine.getConnection(1) ^ secondLine.getConnection(2)
                || !secondLine.getConnection(1))
                .isTrue();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        for (int lineIndex = 0; lineIndex < ladder.getLadderSize(); lineIndex++) {
            LineOfLadder line = ladder.getLine(lineIndex);
            System.out.print("|");
            for (int i = 0; i < line.getConnectionSize(); i++) {
                boolean connection = line.getConnection(i);
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
        assertAll(
                () -> assertThat(emptyLadder.getFinalPoint(0)).isEqualTo(0),
                () -> assertThat(emptyLadder.getFinalPoint(1)).isEqualTo(1)
        );

        Ladder allLadder = new Ladder(3, 3, new DefaultConnection());
        assertAll(
                () -> assertThat(allLadder.getFinalPoint(0)).isEqualTo(1),
                () -> assertThat(allLadder.getFinalPoint(1)).isEqualTo(0),
                () -> assertThat(allLadder.getFinalPoint(2)).isEqualTo(2)
        );
    }
}
