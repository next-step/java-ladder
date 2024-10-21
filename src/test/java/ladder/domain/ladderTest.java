package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ladderTest {
    @Test
    void 사다리_생성() {
        Ladder ladder = new Ladder(5);
        assertThat(ladder).isNotNull();
    }

    @Test
    void 사다리_최소길이_검증() {
        assertThatThrownBy(() -> new Ladder(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}