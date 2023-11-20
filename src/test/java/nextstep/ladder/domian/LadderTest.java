package nextstep.ladder.domian;

import org.junit.jupiter.api.Test;

public class LadderTest {

    private Ladder ladder;

    @Test
    void 사다리를_생성한다() {
        ladder = new Ladder(3, 3);
        assertThat(ladder.height()).hasSize(3);
    }
}
