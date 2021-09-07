package ladder.util;

import static ladder.domain.ladder.Point.createLast;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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

    @Test
    @DisplayName("containsComma에 null이 들어오면 Exception 발생해야 한다.")
    void containsCommaFailByNullTest() {

        // given
        String input = null;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringUtil.containsComma(input))
            .withMessageMatching("String 값은 null이 들어올 수 없다.");
    }

    @Test
    @DisplayName("splitByComma에 null이 들어오면 Exception 발생해야 한다.")
    void splitByCommaFailByNullTest() {

        // given
        String input = null;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringUtil.splitByComma(input))
            .withMessageMatching("String 값은 null이 들어올 수 없다.");
    }

}