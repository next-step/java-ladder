package nextstep.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PreConditionTest {

    @Test
    @DisplayName("공백 또는 null일 경우 예외 발생한다.")
    public void checkNullOrEmpty() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> PreCondition.checkNullOrEmpty(""));
        assertThatIllegalArgumentException().isThrownBy(() -> PreCondition.checkNullOrEmpty(null));
    }
}
