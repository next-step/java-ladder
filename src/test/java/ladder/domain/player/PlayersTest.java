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
                new Player("Mark"),
                new Player("Sujin"),
                new Player("Yuqi"));
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