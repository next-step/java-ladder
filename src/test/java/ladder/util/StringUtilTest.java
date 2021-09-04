package ladder.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "       "})
    @DisplayName("isBlank()에 공백이 들어와도 true를 반환한다.")
    void isBlankByNothingTest(String input) {

        // when
        boolean result = StringUtil.isBlank(input);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName(",가 포함되어있으면 true를 반환한다.")
    void containsCommaTest() {

        // given
        String input = "test,test2";

        // when
        boolean result = StringUtil.containsComma(input);

        // then
        assertTrue(result);
    }

}