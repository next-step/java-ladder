package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("높이 5")
    @Test
    void 사다리생성() {
        Ladder ladder = new Ladder(new Players("pobi,honux,crong,jk"), new Height(5));
        assertThat(ladder.countOfLine()).isEqualTo(5);
    }
}
