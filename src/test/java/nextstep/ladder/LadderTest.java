package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리는_높이가_1_이상_이여야_한다() {
        assertThatThrownBy(() -> new Ladder(0, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}