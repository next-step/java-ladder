package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {
    @Test
    void 최대사다리_높이가_1미만일경우() {
        assertThatThrownBy(() -> {
            new LadderHeight(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}