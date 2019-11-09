package ladder.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    private static Ladder ladder;

    @BeforeEach
    void setUp() {
        int personCount = 4;
        int ladderHeight = 5;
        ladder = new Ladder(personCount, ladderHeight);
    }

    @Test
    @DisplayName("2차원 배열로 사다리 생성")
    void ladderSizeTest() {
        assertThat(ladder.getHeight()).isEqualTo(5);
        assertThat(ladder.getWidth()).isEqualTo(3);
    }

    @Test
    @DisplayName("연속된 두 칸 모두 사다리가 그려질 수 업다")
    void verifiedLadderTest() {
        boolean[][] ladderTable = ladder.getLadder();
        assertThat(ladderTable[0][0] ^ ladderTable[0][1] || !ladderTable[0][0])
                .isTrue();
        assertThat(ladderTable[1][1] ^ ladderTable[1][2] || !ladderTable[1][1])
                .isTrue();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        boolean[][] ladderTable = ladder.getLadder();
        for (boolean[] line : ladderTable) {
            System.out.print("|");
            for (boolean value : line) {
                if (value) {
                    System.out.print("----|");
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
        }
    }
}
