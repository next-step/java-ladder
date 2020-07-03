package ladder;

import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilTest {

    @ParameterizedTest
    @DisplayName("이름 혹은 사다리 보상의 글자 수가 범위를 넘으면 실패")
    @ValueSource(strings = {"abcdef", "123456", "helloWorld"})
    void FailIfInputSizeBiggerThanBoundary(String input) {
        assertThatThrownBy(() -> StringUtil.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("부족한 글자의 수만큼 white space로 채워지는 지 확인")
    @ValueSource(strings = {"a", "ab", "abc", "abcd"})
    void FixedStringLengthEqualWithExpected(String input) {
        int actual = StringUtil.fixStringLength(input).length();

        assertThat(actual).isEqualTo(5);
    }
}
