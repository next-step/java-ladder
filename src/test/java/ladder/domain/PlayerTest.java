package ladder.domain;

import ladder.exception.InvalidNameException;
import ladder.exception.NameLengthOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerTest {

    @DisplayName("참여자 이름이 null 이거나 공백일경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidNames")
    void validName(String name) {
        assertThatExceptionOfType(InvalidNameException.class).isThrownBy(
                () ->  new Player(name)
        );
    }

    @DisplayName("참여자 이름이 5글자를 넘기면 커스텀 예외를 발생한다.")
    @Test
    void validNameLength() {
        String name = "ohtaeg";
        assertThatExceptionOfType(NameLengthOutOfBoundException.class).isThrownBy(
                () ->  new Player(name)
        );
    }

    static Stream<String> invalidNames() {
        return Stream.of("", "   ", null);
    }
}