package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    void heightIsOverAndEqualThan1_SuccessCreate() {
        assertThat(Height.of(1)).isEqualTo(Height.of(1));
    }

    @Test
    void heightIsUnderThan1_ThrowException() {
        assertThatThrownBy(() -> Height.of(0))
                .isInstanceOf(LadderException.class);
    }
}
