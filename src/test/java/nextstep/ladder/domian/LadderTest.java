package nextstep.ladder.domian;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    private Ladder ladder;

    @DisplayName("사다리를 생성한다")
    @Test
    void 사다리를_생성한다() {
        ladder = new Ladder(3, 3);
        assertThat(ladder.height()).hasSize(3);
    }
}
