package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열이 빈 값인지 테스트")
    void isEmptyTest(String name) {
        assertThat(StringUtils.isEmpty(name)).isTrue();
    }

}