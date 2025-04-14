package ladder.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LadderSlotsPairTest {

    @Test
    void 양쪽_크기_다름() {
        assertThatThrownBy(() -> {
            new LadderSlotsPair("a,b,c", "c,d,e,f");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양쪽의 수는 동일해야 합니다.");
    }

}
