package ladder.domain;

import ladder.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderLineHeightTest {

    @Test
    @DisplayName("0보다 작거나 같은 값이 사다리의 높이 값으로 들어오면, Exception을 throw 한다.")
    void should_throw_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeight(0))
                .withMessage(ErrorMessage.LADDER_HEIGHT_IS_WRONG);
    }

}
