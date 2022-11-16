package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> PlayerName.valueOf(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  "})
    void blankName(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> PlayerName.valueOf(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"foobar", "foobarx", "hogehoge", "123456", "1234567"})
    void tooLongName(final String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> PlayerName.valueOf(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"f", "fo", "foo", "foob", "fooba", "1", "12", "123", "1234", "12345"})
    void validName(final String carName) {
        assertThatCode(() -> PlayerName.valueOf(carName)).doesNotThrowAnyException();
    }


}