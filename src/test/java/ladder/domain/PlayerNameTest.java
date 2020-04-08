package ladder.domain;

import ladder.exception.InvalidNameException;
import ladder.exception.NameLengthOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerNameTest {

    @DisplayName("참여자 이름이 null 이거나 공백일경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidNames")
    void validName(String name) {
        int position = 0;

        assertThatExceptionOfType(InvalidNameException.class).isThrownBy(
                () ->  new Player(name, position)
        );
    }

    @DisplayName("참여자 이름이 5글자를 넘기면 커스텀 예외를 발생한다.")
    @Test
    void validNameLength() {
        String name = "ohtaeg";
        int position = 0;
        assertThatExceptionOfType(NameLengthOutOfBoundException.class).isThrownBy(
                () ->  new Player(name, position)
        );
    }

    static Stream<String> invalidNames() {
        return Stream.of("", "   ", null);
    }
}