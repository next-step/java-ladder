package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerTest {

    @DisplayName("참여자 이름이 null 이거나 공백일경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidNames")
    void validNameLength(String name) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () ->  new Player(name)
        );
    }

    static Stream<String> invalidNames() {
        return Stream.of("", "   ", null);
    }
}