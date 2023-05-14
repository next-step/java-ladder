package nextstep;

import nextstep.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void 사다리의_높이는_입력받은_높이와_같다() {

        Ladder ladder = Ladder.makeLadder(5, 3);

        assertThat(ladder.ladder()).hasSize(5);
    }
}
