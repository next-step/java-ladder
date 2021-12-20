package ladder.domain;

import ladder.fixture.TestLadderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("높이 5")
    @Test
    void 사다리생성() {
        Ladder ladder = Ladder.of(TestLadderFactory.createPlayer("pobi,honux,crong,jk"), Height.of(5));
        assertThat(ladder.countOfLine()).isEqualTo(5);
    }
}
