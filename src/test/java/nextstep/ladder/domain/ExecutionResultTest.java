package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ExecutionResultTest {

    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝,3000:4", "꽝,5000:2", "꽝,5000,꽝,3000,꽝:5"}, delimiter = ':')
    void 생성성공(String input, int size) {
        assertThat(ExecutionResult.of(input, size)).isInstanceOf(ExecutionResult.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyException(String input) {
        assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(() -> ExecutionResult.of(input, 1));
    }

    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝,3000:3", "꽝,5000:3", "꽝,5000,꽝,3000,꽝:6"}, delimiter = ':')
    void name사이즈와불일치(String input, int size) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ExecutionResult.of(input, size));
    }

}
