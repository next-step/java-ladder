package ladder.model.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

    @Test
    @DisplayName("null 또는 빈 값 체크 테스트")
    void nullOrEmptyOrBlankTest() {
        assertTrue(StringUtil.isNullOrEmpty(null));
        assertTrue(StringUtil.isNullOrEmpty(""));
        assertTrue(StringUtil.isNullOrEmpty("    "));
    }
}