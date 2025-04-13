package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    void createTest() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    void throwExceptionTest() {
        assertThatThrownBy(() -> new Name("pobi56")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid player name length");
    }
}
