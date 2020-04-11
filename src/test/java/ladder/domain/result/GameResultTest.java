package ladder.domain.result;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.row.Position;
import ladder.model.prize.LadderPrize;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    private List<Player> threePlayers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        threePlayers = Arrays.asList(
                new Player("Mark", 0),
                new Player("Ten", 1),
                new Player("Sujin", 2));
    }

    @DisplayName("플레이어 이름과 최종 위치가 담긴 Map과 실행결과와 최종위치가 담긴 List를 주면 플레이어명과 실행결과를 가진 Map을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"Ten:꽝", "Sujin:5000", "Mark:꽝"}, delimiter = ':')
    void createTest(String name, String prizeName) {
        //given
        LadderPrizes ladderPrizes = createThreePrizes();
        Players players = Players.create(threePlayers);
        Rows rows = new Rows(Arrays.asList(createFirstRow(), createSecondRow()));
        Players playersForResult = players.findFinalLocationByName(rows, "all");

        //when
        GameResult gameResult = GameResult.create(playersForResult, ladderPrizes);

        //then
        assertThat(gameResult.findPrizeByPlayerName(name)).isEqualTo(prizeName);
    }

    private LadderPrizes createThreePrizes() {
        return LadderPrizes.create(Arrays.asList(
                new LadderPrize("꽝"),
                new LadderPrize("5000"),
                new LadderPrize("꽝")));
    }

    private Row createFirstRow() {
        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);

        return new Row(result);
    }

    private Row createSecondRow() {
        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), false);
        result.put(new Position(1), true);

        return new Row(result);
    }
}