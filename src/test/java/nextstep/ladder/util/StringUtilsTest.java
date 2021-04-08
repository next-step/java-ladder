package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    @DisplayName("특정 문자열울 좌측에 끼워넣는다.")
    void paddingStringToLeft() {
        String str = "test";

        assertThat(StringUtils.padToLeft(str, 10)).isEqualTo("      test");
    }

    @Test
    @DisplayName("좌측 padding 사용 시 원본 문자열이 충분히 길면 그대로 반환한다.")
    void nothingToDoIfStringIsTooLongWhenUseAddLeftPad() {
        String str = "tdd forever";

        assertThat(StringUtils.padToLeft(str, 10)).isEqualTo(str);
    }

    @Test
    @DisplayName("특정 문자열울 우측에 끼워넣는다.")
    void paddingStringToRight() {
        String str = "test";

        assertThat(StringUtils.padToRight(str, 10)).isEqualTo("test      ");
    }

    @Test
    @DisplayName("우측 padding 사용 시 원본 문자열이 충분히 길면 그대로 반환한다.")
    void nothingToDoIfStringIsTooLongWhenUseAddRightPad() {
        String str = "tdd forever";

        assertThat(StringUtils.padToRight(str, 10)).isEqualTo(str);
    }

    @Test
    @DisplayName("원하는 만큼 문자열을 반복한다.")
    void repeatString() {
        String str = "tdd";

        assertThat(StringUtils.repeat(str, 5)).isEqualTo("tddtddtddtddtdd");
    }
}
