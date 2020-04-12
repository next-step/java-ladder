package ladder.domain.row;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrize;
import ladder.model.prize.LadderPrizes;
import ladder.model.result.GameResult;
import ladder.model.row.Height;
import ladder.model.row.Position;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RowsTest {
    @DisplayName("Rows 객체 생성")
    @Test
    void createTest() {
        //when
        Rows rows = Rows.create(Players.create(createThreePlayers()), new Height(5));

        //then
        assertThat(rows.getRows()).hasSize(5);
    }

    @DisplayName("플레이어 목록과 실행결과 목록을 주면 Game결과를 반환")
    @ParameterizedTest
    @CsvSource(value = {"Yuqi:3000", "Sujin:꽝", "Shuha:5000"}, delimiter = ':')
    void getResult(String playerName, String prizeName) {
        //given
        Rows rows = new Rows(Arrays.asList(createFirstRow(), createSecondRow()));
        Players players = Players.create(createThreePlayers());
        LadderPrizes ladderPrizes = createThreeLadderPrizes();

        //when
        GameResult result = rows.getResult(players, ladderPrizes);

        //then
        assertThat(result.findPrizeByPlayerName(playerName)).isEqualTo(prizeName);
    }

    private LadderPrizes createThreeLadderPrizes() {
        List<LadderPrize> prizes = Arrays.asList(
                new LadderPrize("꽝"),
                new LadderPrize("5000"),
                new LadderPrize("3000"));
        return new LadderPrizes(prizes);
    }

    private Row createFirstRow() {
        Map<Position, Boolean> row = new HashMap<>();
        row.put(Position.of(0), true);
        row.put(Position.of(1), false);
        return new Row(row);
    }

    private Row createSecondRow() {
        Map<Position, Boolean> row = new HashMap<>();
        row.put(Position.of(0), false);
        row.put(Position.of(1), true);
        return new Row(row);
    }

    private List<Player> createThreePlayers() {
        return Arrays.asList(
                new Player("Yuqi"),
                new Player("Sujin"),
                new Player("Shuha"));
    }
}