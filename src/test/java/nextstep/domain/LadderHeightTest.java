package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {
    @Test
    void 사다리_사이즈_체크() {
        assertThatThrownBy(() -> {
            new LadderHeight(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}