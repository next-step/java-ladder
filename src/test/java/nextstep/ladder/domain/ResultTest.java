package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    @Test
    void 빈값_검증() {
        assertThatThrownBy(
                () -> new Result("")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
