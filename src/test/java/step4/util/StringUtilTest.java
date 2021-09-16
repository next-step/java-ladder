package step4.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("isBlank()에 null혹은 빈칸을 입력했을 때 true를 반환한다.")
    void isBlankByNullAndEmptyTest(String input) {

        // when
        boolean result = StringUtil.isBlank(input);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("containsComma()에 comma가 있으면 true를 반환한다.")
    void conatainsCommaTest() {

        // given
        String input = "test,test";

        // when
        boolean result = StringUtil.containsComma(input);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("containsComma()에 null이 들어오면 Exception이 반환되어야 한다.")
    void containsCommaExceptionTest() {

        // given
        String input = null;

        // when & then
        assertThatExceptionOfType(NullPointException.class)
            .isThrownBy(() -> StringUtil.containsComma(input))
            .withMessageMatching("null이 들어올 수 없다.");
    }

    @Test
    @DisplayName("splitByComma() 테스트")
    void splitByCommaTest() {

        // given
        String input = "test1,test2";

        // when
        String[] result = StringUtil.splitByComma(input);

        // then
        assertThat(result).containsExactly("test1", "test2");
    }

    @Test
    @DisplayName("splitByComma()에 null이 들어오면 Exception이 반환되어야 한다.")
    void splitByCommaExceptionTest() {

        // given
        String input = null;

        assertThatExceptionOfType(NullPointException.class)
            .isThrownBy(() -> StringUtil.splitByComma(input))
            .withMessageMatching("null이 들어올 수 없다.");
    }

}
