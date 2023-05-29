package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @Test
    void 사다리높이입력() {
        LadderHeight ladderHeight = new LadderHeight(7);
        assertThat(ladderHeight).isEqualTo(new LadderHeight(7));
    }

    @Test
    void 사다리높이_음수입력() {
        assertThatThrownBy(() -> new LadderHeight(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}