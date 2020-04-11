package ladder.domain.player;

import ladder.model.player.Player;
import ladder.model.player.PlayerName;
import ladder.model.player.Players;
import ladder.model.row.Position;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    private List<Player> threePlayers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        threePlayers = Arrays.asList(
                new Player("Mark", 0),
                new Player("Sujin", 1),
                new Player("Yuqi", 2));
    }

    @DisplayName("Players 객체 생성")
    @Test
    void createTest() {
        //when
        Players players = Players.create(threePlayers);

        //then
        assertThat(players.getPlayerCount()).isEqualTo(3);
    }

    @DisplayName("플레이어의 이름이 중복되면 예외를 던진다.")
    @Test
    void throwExceptionWhenDuplicationNamesTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Players.create(Arrays.asList(
                    new Player("Mark"),
                    new Player("Sujin"),
                    new Player("Sujin")));
        });
    }

    @DisplayName("플레이어 이름을 입력하면, 최종 위치를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"Mark:0", "Sujin:1", "Yuqi:2"}, delimiter = ':')
    void findFinalLocationByNameTest(String input, int finalLocation) {
        //given
        Players players = Players.create(threePlayers);
        Rows rows = createTwoRowsForTest();

        //when
        Players playersForResult = players.findFinalLocationByName(rows, input);

        //then
        assertThat(playersForResult.getPlayers().size()).isEqualTo(1);
        assertThat(playersForResult.getPlayers().get(0).getName()).isEqualTo(new PlayerName(input));
        assertThat(playersForResult.getPlayers().get(0).getPosition()).isEqualTo(new Position(finalLocation));
    }

    @DisplayName("존재하지 않는 플레이어명을 입력하면, 전체 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"shusu", "Idle"})
    void findFinalLocationsByNameWhenNonValidName(String input) {
        //given
        Players players = Players.create(threePlayers);
        Rows rows = createTwoRowsForTest();

        //when
        Players playersForResult = players.findFinalLocationByName(rows, input);

        //then
        assertThat(playersForResult.getPlayers().size()).isEqualTo(3);
    }

    private Rows createTwoRowsForTest() {
        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);
        Row row = new Row(result);

        Map<Position, Boolean> result2 = new HashMap<>();
        result2.put(new Position(0), true);
        result2.put(new Position(1), false);
        Row row2 = new Row(result2);

        return new Rows(Arrays.asList(row, row2));
    }
}