package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {
    private static final int MAX_NAME_SIZE = 5;
    
    @DisplayName("이름이 null 또는 공백이 아니고 5자 이하라면 사용자 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = { "a", "ab", "abc", "abcd", "abcde" })
    void constructor(String name) {
        assertThat(new User(name, MAX_NAME_SIZE)).isNotNull();
    }

    @DisplayName("이름이 null 이거나 공백 또는 최대 길이가 5자를 넘는다면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = "abcdef")
    void constructor_when_invalid_name(String name) {
        assertThatThrownBy(() -> new User(name, MAX_NAME_SIZE)).isInstanceOf(IllegalArgumentException.class).hasMessage("The maximum length of a name cannot exceed " + MAX_NAME_SIZE + " characters.");
    }
}
