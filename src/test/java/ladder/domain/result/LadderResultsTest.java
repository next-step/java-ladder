package ladder.domain.result;

import ladder.domain.player.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultsTest {

    @Test
    void throwExceptionWhenDifferentSize() {
        Players players = Players.of("aaa,bbb,ccc");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderResults.of("10,20", players);
        }).withMessageMatching("Participants and results have different sizes.");
    }
}
