package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @Test
    void testCreateLadderGame() {
        List<Name> names = List.of(new Name("pobi"), new Name("honux"));
        Ladder ladder = new Ladder(5, 2);
        LadderGame ladderGame = new LadderGame(names, ladder);

        assertThat(ladderGame.getNames()).containsOnly(new Name("pobi"), new Name("honux"));
        assertThat(ladderGame.getLadder().getLines()).size().isEqualTo(5);
    }

}
