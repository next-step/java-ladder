package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.LengthLimitException;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    void create() {
        Name ladderName = Name.of("a");
        assertThat(ladderName).isEqualTo(Name.of("a"));
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> {
            Name.of("abbbbb");
        }).isInstanceOf(LengthLimitException.class);
    }
}