package nextstep.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("String null, \"\"입력 테스트")
    void validationNotNullAndEmpty(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringUtils.validationNotNullAndEmpty(inputString));
    }
}