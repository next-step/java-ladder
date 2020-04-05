package ladder;

import ladder.model.Height;
import ladder.model.Player;
import ladder.model.Players;
import ladder.model.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowsTest {
    @DisplayName("Rows 객체 생성")
    @Test
    void createTest() {
        //given
        List<Player> players = Arrays.asList(
                new Player("Mark"),
                new Player("Palm"),
                new Player("Jyung")
        );

        //when
        Rows rows = Rows.create(Players.create(players), new Height(5));

        //then
        assertThat(rows.getRows()).hasSize(5);
    }
}