package ladder.domain.row;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.row.Height;
import ladder.model.row.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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


    private List<Player> createThreePlayers() {
        return Arrays.asList(
                new Player("Yuqi"),
                new Player("Sujin"),
                new Player("Shuha"));
    }
}