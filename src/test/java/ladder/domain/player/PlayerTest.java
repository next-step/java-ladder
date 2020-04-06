package ladder.domain.player;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.player.Position;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @DisplayName("다음 Row 를 주면, Player의 다음 Location을 준다.")
    @Test
    void findNextLocation() {
        //given
        Player player = new Player("Mark", 0);
        Player player2 = new Player("Palm", 1);
        Player player3 = new Player("Soo", 2);
        Players players = Players.create(Arrays.asList(player, player2, player3));

        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);
        Row row = new Row(result);

        //when, then
        assertThat(player.findNextLocation(row)).isEqualTo(new Position(1));
        assertThat(player2.findNextLocation(row)).isEqualTo(new Position(0));
        assertThat(player3.findNextLocation(row)).isEqualTo(new Position(2));
    }

    @DisplayName("전체 Rows 를 주면, Player의 마지막 Location을 준다.")
    @Test
    void findFinalLocationTest() {
        //given
        Player player = new Player("Mark", 0);
        Player player2 = new Player("Palm", 1);
        Player player3 = new Player("Soo", 2);

        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);
        Row row = new Row(result);

        Map<Position, Boolean> result2 = new HashMap<>();
        result2.put(new Position(0), false);
        result2.put(new Position(1), true);
        Row row2 = new Row(result2);

        Rows rows = new Rows(Arrays.asList(row, row2));

        //when, then
        assertThat(player.findFinalLocation(rows)).isEqualTo(new Position(2));
        assertThat(player2.findFinalLocation(rows)).isEqualTo(new Position(0));
        assertThat(player3.findFinalLocation(rows)).isEqualTo(new Position(1));
    }
}