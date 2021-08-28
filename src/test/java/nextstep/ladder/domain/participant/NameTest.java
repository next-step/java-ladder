package nextstep.ladder.domain.participant;

import nextstep.ladder.exception.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @ParameterizedTest
    @DisplayName("이름이 null이면 예외가 발생한다")
    @NullSource
    void nullNameTest(String name) {
        assertThrows(InvalidNameException.class, () -> new Name(name));
    }

    @ParameterizedTest
    @DisplayName("이름이 5자 초과하는 경우 예외가 발생한다")
    @ValueSource(strings = {"abcdef", "aaaaaaa", "aaaaaaaaaaa"})
    void exceedFiveLengthOfNameTest(String name) {
        assertThrows(InvalidNameException.class, () -> new Name(name));
    }

}