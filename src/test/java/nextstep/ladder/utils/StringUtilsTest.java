package nextstep.ladder.utils;

import static nextstep.ladder.utils.StringUtils.rangeStringLength;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    @DisplayName("문자열의 길이가 최대값을 넘기지 않으면, 문자열이 반환된다.")
    void rangeStringLengthTest() {
        String word = "abcde";
        assertThat(rangeStringLength(word, 5)).isEqualTo(word);
    }

    @Test
    @DisplayName("문자열의 길이가 최대값을 넘기면 RuntimeException 이 발생한다.")
    void rangeStringLengthExceptionTest() {
        String word = "abcde";
        assertThatIllegalArgumentException()
            .isThrownBy(() -> rangeStringLength(word, 4));
    }

}
