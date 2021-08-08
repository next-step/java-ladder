package nextstep.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 문자열이 null이거나 길이가 0인 경우 참을 반환해야 한다")
    void isEmpty(String args) throws Exception {
        Assertions.assertThat(StringUtils.isEmpty(args)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asfhasf", "a", "lskdjgslkdgjsldkjg"})
    @DisplayName("입력 문자열이 null이거나 길이가 0이 아닌 경우 거짓을 반환해야 한다")
    void isNonEmpty(String args) throws Exception {
        Assertions.assertThat(StringUtils.isEmpty(args)).isFalse();
    }
}
