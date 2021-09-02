package ladder.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("isBlank()에 null혹은 빈칸을 입력했을 때 true를 반환한다.")
    void isBlankByNullAndEmptyTest(String input) {

        // when
        boolean result = StringUtil.isBlank(input);

        // then
        assertTrue(result);
    }

}