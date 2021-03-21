package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderBoardTest {

    @Test
    @DisplayName("prize를 통해 결과값 테스트")
    void prize() {
        LineList lineList = new LineList();
        lineList.add(Arrays.asList(new Point(false), new Point(false), new Point(true), new Point(false)));
        lineList.add(Arrays.asList(new Point(false), new Point(true), new Point(false), new Point(true)));
        lineList.add(Arrays.asList(new Point(false), new Point(true), new Point(false), new Point(false)));
        LadderList ladderList = new LadderList(Arrays.asList(new Ladder(0, "꽝"), new Ladder(1, "100"), new Ladder(2, "200"), new Ladder(3, "300")));
        Player player = new Player("pobi", 1);
        Player player2 = new Player("tax", 0);
        Prize expectedPrize = new Prize("300");

        Prize expectedPrize2 = new Prize("꽝");
        LadderBoard ladderBoard = new LadderBoard(lineList, ladderList);
//        Prize prize = ladderBoard.prize(player);
//        assertThat(prize).isEqualTo(expectedPrize);
        Prize prize2 = ladderBoard.prize(player2);
        assertThat(prize2).isEqualTo(expectedPrize2);
    }
}
