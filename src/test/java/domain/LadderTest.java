package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    void play() {
        Players players = Players.from("pobi", "nimoh", "test", "race", "lotto");
        int ladderHeight = 5;

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.from(players.size(), (playerCount) -> List.of(true, false, true, false)));
        }

        List<String> results = List.of("꽝", "2000", "3000", "꽝", "10000");
        Ladder ladder = Ladder.from(lines);
        LadderResult ladderResult = ladder.play(players, results);
        assertThat(ladderResult.getResult("pobi")).isEqualTo("2000");
        assertThat(ladderResult.getResult("nimoh")).isEqualTo("꽝");
        assertThat(ladderResult.getResult("test")).isEqualTo("꽝");
        assertThat(ladderResult.getResult("race")).isEqualTo("3000");
        assertThat(ladderResult.getResult("lotto")).isEqualTo("10000");

    }
}
