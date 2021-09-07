package laddergame.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("참여자들 이름은")
class UserNamesTest {

    @DisplayName("쉼표로 구분 됨")
    @Test
    void create() {
        String names = "pobi,honux,crong,jk";
        assertThat(new UserNames(names)).isEqualTo(new UserNames(names));
    }

    @DisplayName("쉼표 이외의 구분자 사용시 예외 발생")
    @Test
    void delimiterNotComma() {
        assertThatThrownBy(() -> new UserNames("pobi/crong")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값이면 예외 발생")
    @ParameterizedTest
    @MethodSource("blankString")
    void isBlank(String blankValue) {
        assertThatThrownBy(() -> new UserNames(blankValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<String> blankString() {
        return Stream.of("", "    ", null);
    }
}
