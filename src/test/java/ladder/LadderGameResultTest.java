package ladder;

import ladder.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {
    @Test
    void createTest() {
        //given
        Player player = new Player("Mark", 0);
        Player player2 = new Player("Palm", 1);
        Player player3 = new Player("Soo", 2);

        Map<Integer, Boolean> result = new HashMap<>();
        result.put(0, true);
        result.put(1, false);
        Row row = new Row(result);
        Map<Integer, Boolean> result2 = new HashMap<>();
        result2.put(0, false);
        result2.put(1, true);
        Row row2 = new Row(result2);
        Rows rows = new Rows(Arrays.asList(row, row2));
        LadderResult ladderResult = LadderResult.create(Players.create(Arrays.asList(player, player2, player3)), rows);

        List<LadderPrize> allLadderPrizes = Arrays.asList(
                new LadderPrize("꽝"),
                new LadderPrize("5000"),
                new LadderPrize("꽝"));
        LadderPrizes ladderPrizes = LadderPrizes.create(allLadderPrizes);

        //when
        LadderGameResult ladderGameResult = LadderGameResult.create(ladderResult, ladderPrizes);

        //then
        assertThat(ladderGameResult.findPrizeOfPlayer(player).getPrizeName()).isEqualTo("꽝");
        assertThat(ladderGameResult.findPrizeOfPlayer(player2).getPrizeName()).isEqualTo("꽝");
        assertThat(ladderGameResult.findPrizeOfPlayer(player3).getPrizeName()).isEqualTo("5000");
    }
}
