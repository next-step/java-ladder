package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class AwardTest {

    @Test
    void 당첨_여부에_빈값_에러() {
        assertThatThrownBy(() -> new Award(""))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
