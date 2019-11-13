package ladder.game;

import ladder.structure.Ladder;
import ladder.structure.connection.RandomConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThat(ladder.isConnected(0, 0) ^ ladder.isConnected(0, 1)
                || !ladder.isConnected(0, 0))
                .isTrue();
        assertThat(ladder.isConnected(1, 1) ^ ladder.isConnected(1, 2)
                || !ladder.isConnected(1, 1))
                .isTrue();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        int lineWidth = personCount - 1;
        for (int height = 0; height < ladderHeight; height++) {
            System.out.print("|");
            for (int width = 0; width < lineWidth; width++) {
                if (ladder.isConnected(height, width)) {
                    System.out.print("----|");
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
        }
    }
}
