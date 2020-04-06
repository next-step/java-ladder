package ladder.domain.result;

import ladder.model.player.Player;
import ladder.model.player.PlayerName;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrize;
import ladder.model.prize.LadderPrizes;
import ladder.model.prize.PrizeName;
import ladder.model.result.GameResult;
import ladder.model.row.Position;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @DisplayName("플레이어 이름과 최종 위치가 담긴 Map과 실행결과와 최종위치가 담긴 List를 주면 플레이어명과 실행결과를 가진 Map을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"Ten:꽝", "Sujin:5000", "Mark:꽝"}, delimiter = ':')
    void createTest(String name, String prizeName) {
        //given
        LadderPrizes ladderPrizes = LadderPrizes.create(Arrays.asList(
                new LadderPrize("꽝"),
                new LadderPrize("5000"),
                new LadderPrize("꽝")));

        Players players = Players.create(Arrays.asList(
                new Player("Mark", 0),
                new Player("Ten", 1),
                new Player("Sujin", 2)));

        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);
        Row row = new Row(result);

        Map<Position, Boolean> result2 = new HashMap<>();
        result2.put(new Position(0), false);
        result2.put(new Position(1), true);
        Row row2 = new Row(result2);
        Rows rows = new Rows(Arrays.asList(row, row2));

        Map<PlayerName, Position> finalLocationByName = players.findFinalLocationByName(rows, "all");

        //when
        GameResult gameResult = GameResult.create(finalLocationByName, ladderPrizes);

        //then
        assertThat(gameResult.findPrizeByPlayerName(name)).isEqualTo(new PrizeName(prizeName));
    }
}
