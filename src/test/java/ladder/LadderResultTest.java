package ladder;

import ladder.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @DisplayName("Rows와 Players 를 주면, LadderResult 를 생성한다.")
    @Test
    void createTest() {
        //given
        List<Player> players = Arrays.asList(
                new Player("Mark", 0),
                new Player("Palm", 1),
                new Player("Jyung", 2));
        Rows rows = Rows.create(Players.create(players), new Height(5));

        //when
        LadderResult ladderResult = LadderResult.create(Players.create(players), rows);

        //then
        assertThat(ladderResult.getSize()).isEqualTo(3);
    }
}
