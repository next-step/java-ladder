package nextstep.ladder.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;



class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("isBlank 메서드가 입력값이 null or 공백 포함하여 비어있을 때 true를 반환한다.")
    void isBlankTest(String value) {
        Assertions.assertThat(StringUtils.isBlank(value)).isTrue();
    }
}