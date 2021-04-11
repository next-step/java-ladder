package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void create() {
        assertThatCode(() -> Member.from("pobi")).doesNotThrowAnyException();
    }

    @Test
    void validNameLength() {
        assertThatThrownBy(() -> Member.from("pobi77")).isInstanceOf(IllegalArgumentException.class);
    }
}
