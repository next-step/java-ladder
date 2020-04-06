package ladder.domain.result;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.result.LadderResult;
import ladder.model.row.Height;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @DisplayName("Rows와 Players 를 주면, LadderResult 를 생성한다.")
    @Test
    void createTest() {
        //given
        List<Player> players = Arrays.asList(
                new Player("Mark", 0),
                new Player("Ten", 1),
                new Player("Jaehy", 2));
        Map<Integer, Boolean> result = new HashMap<>();
        result.put(0, true);
        result.put(1, false);
        Row row = new Row(result);

        Map<Integer, Boolean> result2 = new HashMap<>();
        result2.put(0, false);
        result2.put(1, true);
        Row row2 = new Row(result2);

        Rows rows = new Rows(Arrays.asList(row, row2));

        //when
        LadderResult ladderResult = LadderResult.create(Players.create(players), rows);

        //then
        assertThat(ladderResult.getSize()).isEqualTo(3);
    }
}
