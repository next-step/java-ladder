package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.Ladder;
import laddergame.domain.Participates;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    LadderGame game = new LadderGame();

    @Test
    public void 사다리_생성() {
        int height = 4;
        Ladder ladder = game.createLadder(new Participates(List.of("somin", "hi")), height);

        assertThat(ladder.getLines().size()).isEqualTo(height);

    }
}
