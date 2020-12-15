package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.LadderSize.LADDER_HEIGHT_IS_WRONG;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderSizeTest {

    @Test
    @DisplayName("0보다 작거나 같은 값이 사다리의 높이 값으로 들어오면, Exception을 throw 한다.")
    void should_throw_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderSize(0, -1))
                .withMessage(LADDER_HEIGHT_IS_WRONG);
    }

}
