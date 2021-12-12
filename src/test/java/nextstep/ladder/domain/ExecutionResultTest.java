package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.exception.ExecutionResultNullPointerException;
import nextstep.ladder.exception.ExecutionResultSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ExecutionResultTest {

    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝,3000:4", "꽝,5000:2", "꽝,5000,꽝,3000,꽝:5"}, delimiter = ':')
    @DisplayName("생성 성공")
    void create(String input, int size) {
        assertThat(ExecutionResult.of(input, size)).isInstanceOf(ExecutionResult.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 Empty 일 경우 예외처리")
    void nullOrEmptyException(String input) {
        assertThatExceptionOfType(ExecutionResultNullPointerException.class)
            .isThrownBy(() -> ExecutionResult.of(input, 1));
    }

    @ParameterizedTest
    @CsvSource(value = {"꽝,5000,꽝,3000:3", "꽝,5000:3", "꽝,5000,꽝,3000,꽝:6"}, delimiter = ':')
    @DisplayName("players 사이즈랑 일치하지 않을 경우 예외처리")
    void executionResultSizeException(String input, int size) {
        assertThatExceptionOfType(ExecutionResultSizeException.class)
            .isThrownBy(() -> ExecutionResult.of(input, size));
    }

}
