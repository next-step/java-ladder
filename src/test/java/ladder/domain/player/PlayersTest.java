package ladder.domain.player;

import ladder.model.player.Player;
import ladder.model.player.PlayerName;
import ladder.model.player.Players;
import ladder.model.player.Position;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    @DisplayName("Players 객체 생성")
    @Test
    void createTest() {
        //given
        List<Player> allPlayers = Arrays.asList(
                new Player("Mark"),
                new Player("Palm"),
                new Player("Jyung"));

        //when
        Players players = Players.create(allPlayers);

        //then
        assertThat(players.getPlayerCount()).isEqualTo(3);
    }

    @DisplayName("플레이어의 이름이 중복되면 예외를 던진다.")
    @Test
    void throwExceptionWhenDuplicationNamesTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Players.create(Arrays.asList(
                    new Player("Mark"),
                    new Player("Sujin"),
                    new Player("Sujin")));
        });
    }

    @DisplayName("플레이어 이름을 입력하면, 최종 위치를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"Mark:0", "Ten:1", "Sujin:2"}, delimiter = ':')
    void findFinalLocationByNameTest(String input, int finalLocation) {
        //given
        Players players = Players.create(Arrays.asList(
                new Player("Mark", 0),
                new Player("Ten", 1),
                new Player("Sujin", 2)));

        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);
        Row row = new Row(result);

        Map<Position, Boolean> result2 = new HashMap<>();
        result2.put(new Position(0), true);
        result2.put(new Position(1), false);
        Row row2 = new Row(result2);
        Rows rows = new Rows(Arrays.asList(row, row2));

        //when
        Map<PlayerName, Position> finalLocationByName = players.findFinalLocationByName(rows, input);

        //then
        assertThat(finalLocationByName.get(new PlayerName(input))).isEqualTo(new Position(finalLocation));
    }

    @DisplayName("존재하지 않는 플레이어명을 입력하면, 전체 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"shusu", "Idle"})
    void findFinalLocationsByNameWhenNonValidName(String input) {
        //given
        Players players = Players.create(Arrays.asList(
                new Player("Mark", 0),
                new Player("Ten", 1),
                new Player("Sujin", 2)));

        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);
        Row row = new Row(result);

        Map<Position, Boolean> result2 = new HashMap<>();
        result2.put(new Position(0), true);
        result2.put(new Position(1), false);
        Row row2 = new Row(result2);
        Rows rows = new Rows(Arrays.asList(row, row2));

        //when
        Map<PlayerName, Position> finalLocationByName = players.findFinalLocationByName(rows, input);

        //then
        assertThat(finalLocationByName.size()).isEqualTo(3);
        assertThat(finalLocationByName.get(new PlayerName("Mark"))).isEqualTo(new Position(0));
        assertThat(finalLocationByName.get(new PlayerName("Ten"))).isEqualTo(new Position(1));
        assertThat(finalLocationByName.get(new PlayerName("Sujin"))).isEqualTo(new Position(2));
    }
}