package ladder.domain.core.line.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.core.line.name.Name.ERROR_MESSAGE_REQUIRED_NAME;
import static ladder.domain.core.line.name.LadderResult.ERROR_MESSAGE_MAX_LEN_NAME;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultTest {
    @DisplayName("null, 공백 체크")
    @Test
    void blankNameTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LadderResult(null))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LadderResult(" "))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);
    }

    @DisplayName("최대 문자 길이 체크")
    @Test
    void maxNameLengthTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LadderResult("꽝꽝꽝꽝꽝꽝"))
            .withMessage(ERROR_MESSAGE_MAX_LEN_NAME);
    }
}
