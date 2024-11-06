package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {
    private  static  Players players = new Players(new String[]{"a","b","c","d","e"});
    private static String[] results = new String[]{"꽝", "1000", "2000", "3000", "4000"};
    @Test
    void create() {
        LadderGame ladderGame = new LadderGame(6, players, new RandomDecision());
        assertThat(ladderGame.getLines()).hasSize(6);
    }

    @Test
    void getAllPlayerResult() {
        LadderGame ladderGame = new LadderGame(6, players, new RandomDecision());
        Map<String, String> result = ladderGame.getAllPlayerResult(results);
        assertThat(result.size()).isEqualTo(5);
    }
}
