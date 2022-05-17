package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void init() {
        Ladder ladder = Ladder.init(3, Height.of(3));
        assertThat(ladder.lines()).hasSize(3);
    }

    @Test
    void initFail_ThrowException() {
        assertThatThrownBy(() -> Ladder.init(-1, Height.of(3)))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(LadderExceptionCode.FAIL_LADDER_INITIALIZATION.getMessage());

    }
}
