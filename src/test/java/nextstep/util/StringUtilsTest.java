package nextstep.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 유틸 클래스 테스트")
class StringUtilsTest {

    @DisplayName("문자열이 null 이거나 비어있다면 true 를 반환한다")
    @NullAndEmptySource
    @ParameterizedTest
    void isEmpty(String stringValue) {
        assertThat(StringUtils.isEmpty(stringValue)).isTrue();
    }
}
