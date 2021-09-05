package ladder.user;

import ladder.user.UserName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("참여자 이름은")
class UserNameTest {

    @DisplayName("이름을 생성자의 파라메터로 가짐")
    @Test
    void create() {
        assertThat(new UserName("joy")).isEqualTo(new UserName("joy"));
    }

    @DisplayName("1자 미만 or 5자 초과시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings={"", "abcdef"})
    void nameLength(String name) {
        assertThatThrownBy(() -> new UserName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값이면 예외 발생")
    @ParameterizedTest
    @MethodSource("blankString")
    void isBlank(String blankValue) {
        assertThatThrownBy(() -> new UserName(blankValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<String> blankString() {
        return Stream.of("", "    ", null);
    }
}
