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
        ladder = new Ladder(3, 3, () -> true);
        assertThat(ladder.lines()).hasSize(3);
    }

    @DisplayName("사다리를 이동한다")
    @Test
    void 사다리를_이동한다() {
        ladder = new Ladder(1, 2, () -> true);
        assertThat(ladder.move(0)).isEqualTo(1);
    }
}
