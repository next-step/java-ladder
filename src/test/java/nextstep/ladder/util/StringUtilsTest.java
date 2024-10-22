package nextstep.ladder.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;


class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("isBlank 메서드가 입력값이 null or 공백 포함하여 비어있을 때 true를 반환한다.")
    void isBlankTest(String value) {
        assertThat(StringUtils.isBlank(value)).isTrue();
    }

    @Test
    @DisplayName("lPad 메서드가 입력값에 따라 왼쪽을 빈 문자열로 채워 반환한다.")
    void lPadTest() {
        assertThat(StringUtils.lPad("홍길동", 5)).isEqualTo("  홍길동");
        assertThat(StringUtils.lPad("홍길동동", 5)).isEqualTo(" 홍길동동");
        assertThat(StringUtils.lPad("홍길동동", 1)).isEqualTo("홍길동동");
    }
}