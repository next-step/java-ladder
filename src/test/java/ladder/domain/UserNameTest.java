package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNameTest {
    @Test
    @DisplayName("UserName 생성자 테스트")
    void constructor() {
        assertThat(new UserName("aaa")).isEqualTo(new UserName("aaa"));
    }

    @Test
    @DisplayName("이름을 최대5글자까지 부여할 수 있다.")
    void validateNameLimitFiveLength() {
        assertThatThrownBy(() -> {
                new UserName("aaaaaa");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("nameAndBlank")
    @DisplayName("name의 길이에따라 빈칸과 조홥된 String을 반환한다.")
    void getNameAndBlank(String name, String nameAndBlank) {
        assertThat(new UserName(name).getNameAndBlank()).isEqualTo(nameAndBlank);
    }

    private static Stream<Arguments> nameAndBlank() {
        return Stream.of(
                Arguments.of("aaaaa", "aaaaa"),
                Arguments.of("aaaa", "aaaa "),
                Arguments.of("aaa", " aaa "),
                Arguments.of("aa", "  aa "),
                Arguments.of("a", "   a ")
        );
    }

}
