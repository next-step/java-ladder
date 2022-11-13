package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    @Test
    void testArriveAt() {
        Users users = Users.from(new String[]{"pobi", "honux", "crong"});
        List<Line> lines = List.of(
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(false, true, false))
        );
        Ladder ladder = new Ladder(lines);
        LadderGame ladderGame = new LadderGame(users, ladder);

        assertThat(ladderGame.arriveAt("pobi")).isEqualTo(1);
        assertThat(ladderGame.arriveAt("honux")).isEqualTo(0);
        assertThat(ladderGame.arriveAt("crong")).isEqualTo(2);
    }
}
