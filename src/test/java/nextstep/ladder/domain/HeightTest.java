package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @Test
    void heightIsUnderThan1_ThrowException() {
        assertThatThrownBy(() -> Height.of(0))
                .isInstanceOf(LadderException.class);
    }
}
