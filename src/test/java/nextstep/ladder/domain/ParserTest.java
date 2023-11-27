package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    @DisplayName("구분자로 문자열 분리")
    @Test
    void 문자열_분리() {
        Assertions.assertThat(Parser.splitString("pobi, next, step"))
                .containsExactly("pobi", "next", "step");
    }

    @DisplayName("문자열 -> 숫자 파싱")
    @Test
    void 숫자_파싱() {
        Assertions.assertThat(Parser.numberFormatParsing("5"))
                .isEqualTo(5);
    }

    @DisplayName("숫자가 아닐경우 예외발생")
    @Test
    void 숫자가_아닐경우() {
        assertThatThrownBy(()-> Parser.numberFormatParsing("7층"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닙니다.");
    }
}