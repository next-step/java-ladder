package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LadderNameTest {
    @Test
    void create() {
        LadderName ladderName = LadderName.of("a");
        assertThat(ladderName).isEqualTo(LadderName.of("a"));
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> {
            LadderName.of("abbbbb");
        }).isInstanceOf(LengthLimitException.class);
    }
}