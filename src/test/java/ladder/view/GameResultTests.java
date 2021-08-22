package ladder.view;

import ladder.domain.Participant;
import ladder.domain.Results;
import ladder.view.GameResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTests {
    @Test
    void create() {
        Participant participant = Participant.of(Arrays.asList("pobi", "honux", "crong", "jk"));
        Results results = Results.of(Arrays.asList("꽝", "5000", "꽝", "3000"));
        GameResult gameResult = GameResult.of(participant, results);

        assertThat(gameResult).isEqualTo(GameResult.of(
                Participant.of(Arrays.asList("pobi", "honux", "crong", "jk")),
                Results.of(Arrays.asList("꽝", "5000", "꽝", "3000"))));
    }

}
