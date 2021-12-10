package nextstep.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class StringUtilsTest {


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, \"\"입력 테스트")
    void isNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringUtils.isNullOrEmpty(input));
    }


}