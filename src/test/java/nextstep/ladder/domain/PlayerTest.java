package nextstep.ladder.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void createMatchResult() {
        Player player = new Player("pobi");
        assertThat(player).isEqualTo(new Player("pobi", 0));
    }

    @Test
    void movePositionMatchResult() {
        Player player = new Player("pobi", 0);

        assertThat(player.movePosition(List.of(true, false, true))).isEqualTo(new Player("pobi", 1));
    }

    @Test
    void getNameTest() {
        Player player = new Player("pobi");

        assertThat(player.getName()).isEqualTo(new Name("pobi"));
    }

    @Test
    void getNameValueTest() {
        Player player = new Player("pobi");

        assertThat(player.getNameValue()).isEqualTo("pobi");
    }

    @Test
    void getMatchResultTest() {
        List<LadderResult> ladderResults = List.of(new LadderResult("3000"), new LadderResult("꽝"));
        Player player = new Player("pobi", 1);

        assertThat(player.matchResult(ladderResults)).isEqualTo(new LadderResult("꽝"));
    }
}
