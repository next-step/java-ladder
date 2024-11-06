package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    private  static  Players players = new Players(new String[]{"a","b","c","d","e"});
    @Test
    void create() {
        LadderGame ladderGame = new LadderGame(6, players, new RandomDecision());
        Assertions.assertThat(ladderGame.getLines()).hasSize(6);
    }
}
