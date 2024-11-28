package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class LadderWidthTest {

    @Test
    void 다리의_넓이는_2개이상이여야한다() {
        assertThatCode(() -> new LadderWidth(2)).doesNotThrowAnyException();
    }

    @Test
    void 다리의_넓이는_2개미만이면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderWidth(1));
    }
}
