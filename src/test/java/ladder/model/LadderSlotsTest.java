package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LadderSlotsTest {

    @Test
    void 이름_확인() {
        LadderSlots ladderSlots = new LadderSlots("a,b,c");
        assertThat(ladderSlots.hasName("a")).isTrue();
        assertThat(ladderSlots.hasName("d")).isFalse();
    }

    @Test
    void 크기_확인() {
        LadderSlots ladderSlots = new LadderSlots("a,b,c");
        assertThat(ladderSlots.isSize(3)).isTrue();
        assertThat(ladderSlots.isSize(4)).isFalse();
    }

}
