package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.RandomConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        List<List<Boolean>> ladderResult = ladder.getConnectedLine();
        assertThat(ladderResult.get(0).get(0) ^ ladderResult.get(0).get(1)
                || !ladderResult.get(0).get(0))
                .isTrue();
        assertThat(ladderResult.get(1).get(1) ^ ladderResult.get(1).get(2)
                || !ladderResult.get(1).get(1))
                .isTrue();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        List<List<Boolean>> ladderResult = ladder.getConnectedLine();
        for (List<Boolean> line : ladderResult) {
            System.out.print("|");
            for (Boolean connection : line) {
                if (connection) {
                    System.out.print("----|");
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
        }
    }
}
