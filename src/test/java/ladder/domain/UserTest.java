package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserTest {
    @DisplayName("이름이 같다면 true 를 리턴하고 아니라면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("equalsSet")
    void equals(String name, String otherName, boolean expected) {
        assertThat(new User(name).equals(new User(otherName))).isEqualTo(expected);
    }
    
    private static Stream<Arguments> equalsSet() {
        return Stream.of(
                Arguments.arguments("pobi", "pobi", true),
                Arguments.arguments("pobi", "honix", false),
                Arguments.arguments("pobi", "", false),
                Arguments.arguments("", "pobi", false)
        );
    }
}
