package ladder.game;

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

    @Test
    @DisplayName("사다리 게임의 포인트 이동 확인")
    void getLadderPoints() {
        List<List<Integer>> emptyLadderResults =
                new Ladder(2, 3, new NoneConnection()).findPointsByLine();
        assertAll(
                () -> assertThat(emptyLadderResults.get(0).get(0)).isEqualTo(0),
                () -> assertThat(emptyLadderResults.get(0).get(1)).isEqualTo(1),

                () -> assertThat(emptyLadderResults.get(1).get(0)).isEqualTo(0),
                () -> assertThat(emptyLadderResults.get(1).get(1)).isEqualTo(1),

                () -> assertThat(emptyLadderResults.get(2).get(0)).isEqualTo(0),
                () -> assertThat(emptyLadderResults.get(2).get(1)).isEqualTo(1)
        );

        List<List<Integer>> allLadderResults =
                new Ladder(3, 3, new DefaultConnection()).findPointsByLine();
        assertAll(
                () -> assertThat(allLadderResults.get(0).get(0)).isEqualTo(1),
                () -> assertThat(allLadderResults.get(0).get(1)).isEqualTo(0),
                () -> assertThat(allLadderResults.get(0).get(2)).isEqualTo(2),

                () -> assertThat(allLadderResults.get(1).get(0)).isEqualTo(0),
                () -> assertThat(allLadderResults.get(1).get(1)).isEqualTo(1),
                () -> assertThat(allLadderResults.get(1).get(2)).isEqualTo(2),

                () -> assertThat(allLadderResults.get(2).get(0)).isEqualTo(1),
                () -> assertThat(allLadderResults.get(2).get(1)).isEqualTo(0),
                () -> assertThat(allLadderResults.get(2).get(2)).isEqualTo(2)
        );
    }
}
