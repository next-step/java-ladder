package nextstep.ladder.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @ParameterizedTest
    @DisplayName("이름은 1~5글자여야 한다")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void validLengthTest(String value) {
        assertDoesNotThrow(() -> new Name(value));
    }

    @ParameterizedTest
    @DisplayName("이름은 빈 문자열이나 null일 수 없다")
    @NullAndEmptySource
    void validEmptyTest(String value) {
        assertThrows(IllegalStateException.class, () -> new Name(value));
    }

    @ParameterizedTest
    @DisplayName("이름은 5글자를 넘을 수 없다")
    @ValueSource(strings = {"aaaaaa", "aaaaaaa"})
    void invalidLengthTest(String value) {

        assertThrows(IllegalStateException.class, () -> {
            Name name = new Name(value);
            assertEquals(name.getValue(), value);
        });

    }

}