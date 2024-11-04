package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultTest {
    @Test
    void 빈값_검증() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Result("")
        );
    }
}
