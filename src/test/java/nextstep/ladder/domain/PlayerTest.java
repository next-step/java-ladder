package nextstep.ladder.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void createTest() {
        Player player = new Player("pobi");
        assertThat(player).isEqualTo(new Player("pobi", 0));
    }

    @Test
    void movePositionTest() {
        Player player = new Player("pobi", 0);

        assertThat(player.movePosition(List.of(true, false, true))).isEqualTo(new Player("pobi", 1));
    }
}
