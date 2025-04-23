package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    void newLadder() {
        assertThat(new Ladder(new Players("pobi,honux,crong,jk"), 5, "꽝,5000,꽝,3000").getLines().size()).isEqualTo(5);
    }

    @Test
    void play_trueLadder() {
        Players players = new Players("pobi,honux,crong,jk");
        String resultString = "꽝,5000,꽝,3000";

        Ladder ladder = new Ladder(players, 5, resultString, () -> true);

        GameResult result = ladder.play(players);

        Map<String, String> results = result.getAllResults();

        assertEquals(players.getCount(), results.size());
        assertThat(result.getResult("pobi")).isEqualTo("5000");
        assertThat(result.getResult("honux")).isEqualTo("꽝");
        assertThat(result.getResult("crong")).isEqualTo("3000");
        assertThat(result.getResult("jk")).isEqualTo("꽝");
    }

    @Test
    void play_falseLadder() {
        Players players = new Players("pobi,honux,crong,jk");
        String resultString = "꽝,5000,꽝,3000";
        Ladder ladder = new Ladder(players, 5, resultString, () -> false);

        GameResult result = ladder.play(players);

        Map<String, String> results = result.getAllResults();

        assertEquals(players.getCount(), results.size());
        assertThat(result.getResult("pobi")).isEqualTo("꽝");
        assertThat(result.getResult("honux")).isEqualTo("5000");
        assertThat(result.getResult("crong")).isEqualTo("꽝");
        assertThat(result.getResult("jk")).isEqualTo("3000");
    }

}
