package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderSlotTest {


    @Test
    void 이름_생성() {
        LadderSlot ladderSlot = new LadderSlot("alice");
        assertThat(ladderSlot.isName("alice")).isTrue();
    }

    @Test
    void 이름_null() {
        assertThatThrownBy(() -> {
            new LadderSlot(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 이름_빔() {
        assertThatThrownBy(() -> {
            new LadderSlot("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 이름_공백() {
        assertThatThrownBy(() -> {
            new LadderSlot("   ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 길이_제한() {
        assertThatThrownBy(() -> {
            new LadderSlot("ABCDEF");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자를 초과할 수 없습니다.");
    }
}
