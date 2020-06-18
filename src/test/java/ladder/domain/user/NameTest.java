package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @ParameterizedTest(name = "input = {0}")
    @NullAndEmptySource
    @DisplayName("이름은 null 이거나 빈문자열일 수 없다.")
    void validate_null_or_empty(String target) {
        assertThatThrownBy(() -> Name.of(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null 이거나 빈 문자열일 수 없습니다.");
    }

    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"abcde", "abcd", "abc", "a", "ab"})
    @DisplayName("이름은 5개 이하의 정상적인 문자열에 대해 생성할 수 있다.")
    void name_success(String target) {
        assertThat(Name.of(target)).isNotNull();
    }

    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"abcdefg", "abcdef"})
    @DisplayName("이름은 최대 5글자까지 부여할 수 있다.")
    void validate_max_length(String target) {
        assertThatThrownBy(() -> Name.of(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자까지 입력할 수 있습니다.");
    }
}