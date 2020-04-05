package ladder;

import ladder.model.Player;
import ladder.model.Players;
import ladder.model.Row;
import ladder.model.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    @DisplayName("게임에 참여하는 사람의 이름이 5글자를 넘으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "일이삼사오육"})
    void validateNameLengthTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(input);
        });
    }

    @DisplayName("다음 Row 를 주면, Player의 다음 Location을 준다.")
    @Test
    void findNextLocation() {
        //given
        Player player = new Player("Mark", 0);
        Player player2 = new Player("Palm", 1);
        Player player3 = new Player("Soo", 2);
        Players players = Players.create(Arrays.asList(player, player2, player3));

        Map<Integer, Boolean> result = new HashMap<>();
        result.put(0, true);
        result.put(1, false);
        Row row = new Row(result);

        //when, then
        assertThat(player.findNextLocation(row)).isEqualTo(1);
        assertThat(player2.findNextLocation(row)).isEqualTo(0);
        assertThat(player3.findNextLocation(row)).isEqualTo(2);
    }

    @DisplayName("전체 Rows 를 주면, Player의 마지막 Location을 준다.")
    @Test
    void findFinalLocationTest() {
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

        //when, then
        assertThat(player.findFinalLocation(rows)).isEqualTo(2);
        assertThat(player2.findFinalLocation(rows)).isEqualTo(0);
        assertThat(player3.findFinalLocation(rows)).isEqualTo(1);
    }
}