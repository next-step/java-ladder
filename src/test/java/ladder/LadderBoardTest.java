package ladder;

import ladder.domain.*;
import ladder.dto.LadderGameRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderBoardTest {

    @Test
    @DisplayName("LadderGameRequest를 통해 생성 테스트")
    void create() {
        String[] nameArray = new String[]{"pobi", "honux", "tax"};
        String[] prizeArray = new String[]{"0", "100", "10"};
        int height = 6;
        LadderGameRequest ladderGameRequest = new LadderGameRequest(nameArray, prizeArray, height);

        LadderBoard ladderBoard = LadderBoard.of(ladderGameRequest);

        assertThat(ladderBoard.prizeList().size()).isEqualTo(prizeArray.length);
        assertThat(ladderBoard.lineList().size()).isEqualTo(height);
    }

    @Test
    @DisplayName("prize를 통해 결과값 테스트")
    void prize() {
        LineList lineList = new LineList();
        lineList.add(Arrays.asList(Direction.of(false, false), Direction.of(false, true), Direction.of(true, false), Direction.of(false, false)));
        lineList.add(Arrays.asList(Direction.of(false, true), Direction.of(true, false), Direction.of(false, true), Direction.of(true, false)));
        lineList.add(Arrays.asList(Direction.of(false, true), Direction.of(true, false), Direction.of(false, false), Direction.of(false, false)));

        PrizeList prizeList = new PrizeList(Arrays.asList(new Prize("꽝"), new Prize("100"), new Prize("200"), new Prize("300")));
        Player pobi = new Player("pobi", 1);
        Player tax = new Player("tax", 0);
        Prize pobiPrize = new Prize("300");
        Prize taxPrize = new Prize("꽝");

        LadderBoard ladderBoard = new LadderBoard(lineList, prizeList);

        assertThat(ladderBoard.prize(pobi)).isEqualTo(pobiPrize);
        assertThat(ladderBoard.prize(tax)).isEqualTo(taxPrize);
    }
}
