package nextstep.ladder.step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.step3.domain.InputString;
import nextstep.ladder.step3.exception.InputNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputStringTest {

    @ParameterizedTest
    @ValueSource(strings = {"hyo", "kim,dong,hyo", "pobi,honux,crong,jk"})
    @DisplayName("생성성공")
    void create(String input) {
        assertThat(new InputString(input)).isInstanceOf(InputString.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"hyo:1", "kim,dong,hyo:3", "pobi,honux,crong,jk:4"}, delimiter = ':')
    @DisplayName("split 성공")
    void split(String input, int size) {
        assertThat(new InputString(input).split().length).isEqualTo(size);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null or empty 체크")
    void nullOrEmptyException(String input) {
        assertThatExceptionOfType(InputNullPointerException.class)
            .isThrownBy(() -> new InputString(input));
    }

}
