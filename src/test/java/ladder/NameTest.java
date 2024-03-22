package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("1~5글자라면 성공적으로 생성한다")
    void success_for_between_1_5_length(String input) {
        assertThatNoException()
            .isThrownBy(() -> Name.of(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("널 또는 빈 문자열이라면 예외가 발생한다")
    void fail_for_null_or_empty(String input) {
        assertThatThrownBy(() -> Name.of(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최대 길이를 초과하면 예외가 발생한다")
    void fail_for_exceed_max_length() {
        String input = "a".repeat(Name.MAX_LENGTH + 1);
        assertThatThrownBy(() -> Name.of(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
