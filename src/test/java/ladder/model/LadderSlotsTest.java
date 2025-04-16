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

    @Test
    void 인덱스_찾기() {
        LadderSlots ladderSlots = new LadderSlots("a,b,c");
        assertThat(ladderSlots.nameIndex("a")).isEqualTo(0);
        assertThat(ladderSlots.nameIndex("c")).isEqualTo(2);

        assertThatThrownBy(() -> {
            ladderSlots.nameIndex("d");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("없는 이름입니다.");
    }

    @Test
    void 인덱스_가져오기() {
        LadderSlots ladderSlots = new LadderSlots("a,b,c");
        assertThat(ladderSlots.indexedSlot(1)).isEqualTo("b");
        assertThat(ladderSlots.indexedSlot(0)).isEqualTo("a");
    }

}
