package nextstep.ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNameTest {

    private static Stream<Arguments> provideArgumentsForFormattedNameTest() {
        return Stream.of(
                Arguments.of("a", "    a"),
                Arguments.of("ab", "   ab"),
                Arguments.of("abc", "  abc"),
                Arguments.of("abcd", " abcd"),
                Arguments.of("abcde", "abcde")
        );
    }

    @MethodSource("provideArgumentsForFormattedNameTest")
    @ParameterizedTest
    @DisplayName("입력된 사용자 이름을 우측정렬 형식에 맞게 반환한다.")
    void test01(String input, String expected) {
        assertThat(UserName.add(input).formattedName())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("사용자 이름은 5자가 넘으면 예외가 발생한다.")
    void test02() {
        String name = "123456";

        assertThatThrownBy(() -> UserName.add(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("사용자 이름이 빈문자열이거나 NULL인 경우 예외가 발생한다. ")
    void test03(String name) {
        assertThatThrownBy(() -> UserName.add(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
