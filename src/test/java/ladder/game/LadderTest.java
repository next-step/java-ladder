package ladder.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    @DisplayName("연속된 두 칸 모두 사다리가 그려질 수 업다")
    void verifiedLadderTest() {
        List<LineOfLadder> ladderTable = ladder.getLadder();
        assertThat(ladderTable.get(0).getLineConnection().get(0) ^ ladderTable.get(0).getLineConnection().get(1)
                || !ladderTable.get(0).getLineConnection().get(0))
                .isTrue();
        assertThat(ladderTable.get(1).getLineConnection().get(1) ^ ladderTable.get(1).getLineConnection().get(2)
                || !ladderTable.get(1).getLineConnection().get(1))
                .isTrue();
    }

    @Test
    @DisplayName("사다리 그리기")
    void drawLadder() {
        List<LineOfLadder> ladderTable = ladder.getLadder();
        for (LineOfLadder line : ladderTable) {
            System.out.print("|");
            for (boolean value : line.getLineConnection()) {
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
