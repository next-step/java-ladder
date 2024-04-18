package nextstep.ladder.domain;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    void getLadder() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder.getLadder().size()).isEqualTo(5);
    }
}
