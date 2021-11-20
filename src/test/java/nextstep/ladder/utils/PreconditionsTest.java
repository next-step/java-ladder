package nextstep.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PreconditionsTest {

    @Test
    @DisplayName("값이 정상적인 경우")
    void checkNotNull() {
        // given
        String param1 = "test data";

        // when & then
        assertDoesNotThrow(() -> Preconditions.checkNotNull(param1, "param1은 필수값입니다."));
    }

    @Test
    @DisplayName("값이 null 인 경우 예외 발생 검증")
    void checkNotNull_exception() {
        // given
        String param1 = null;

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Preconditions.checkNotNull(param1, "param1은 필수값입니다."));
    }

    @Test
    @DisplayName("값이 정상적인 경우")
    void checkEmpty() {
        // given
        List<Boolean> param1 = Arrays.asList(true, false);

        // when & then
        assertDoesNotThrow(() -> Preconditions.checkEmpty(param1, "param1은 필수값입니다."));
    }

    @Test
    @DisplayName("값이 null 이거나 빈 값인 경우 예외 발생 검증")
    void checkEmpty_exception() {
        // given
        List<Boolean> param1 = Collections.emptyList();

        // when & then
        assertAll(() -> {
            assertThatIllegalArgumentException().isThrownBy(() -> Preconditions.checkEmpty(param1, "param1은 필수값입니다."));
            assertThatIllegalArgumentException().isThrownBy(() -> Preconditions.checkEmpty(null, "param1은 필수값입니다."));
        });
    }

    @Test
    @DisplayName("값이 정상적인 경우")
    void checkString() {
        // given
        String param1 = "test";

        // when & then
        assertDoesNotThrow(() -> Preconditions.checkString(param1, "param1은 필수값입니다."));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("값이 null 이거나 빈값인 경우 예외 발생 검증")
    void checkString_exception(String param1) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Preconditions.checkString(param1, "param1은 필수값입니다."));
    }


    @ParameterizedTest
    @CsvSource(value = {
            " 10|     2",
            "  2|     2"
    }, delimiter = '|')
    @DisplayName("최소값이 값이 정상적인 경우")
    void checkMinimumSize(int size, int minimumSize) {
        // when & then
        assertDoesNotThrow(() -> Preconditions.checkMinimumSize(size, minimumSize,
                                                                String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.",
                                                                              minimumSize)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 1|     2",
            " 0|     2"
    }, delimiter = '|')
    @DisplayName("최소값 기준을 넘어가는 경우 예외 발생 검증")
    void checkMinimumSize_IllegalArgumentException(int size, int minimumSize) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Preconditions.checkMinimumSize(size, minimumSize,
                                                                 String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.",
                                                                               minimumSize)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 4|     5",
            " 3|     5"
    }, delimiter = '|')
    @DisplayName("최대값이 정상적인 경우")
    void checkMaximumSize(int size, int maximumSize) {
        // when & then
        assertDoesNotThrow(() -> Preconditions.checkMaximumSize(size, maximumSize,
                                                                String.format("maximumSize(%d) 값보다 작은 값을 입력해 주세요.",
                                                                              maximumSize)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 6|     5",
            " 7|     5"
    }, delimiter = '|')
    @DisplayName("최대값 기준을 넘어가는 경우 예외 발생 검증")
    void checkMaximumSize_exception(int size, int maximumSize) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Preconditions.checkMaximumSize(size, maximumSize,
                                                                 String.format("maximumSize(%d) 값보다 작은 값을 입력해 주세요.",
                                                                               maximumSize)));
    }


    @ParameterizedTest
    @CsvSource(value = {
            " 6|     6",
            " 7|     7"
    }, delimiter = '|')
    @DisplayName("값이 동일한 경우")
    void checkSameSize(int size, int targetSize) {
        // when & then
        assertDoesNotThrow(() -> Preconditions.checkSameSize(size, targetSize, "동일한 값을 입력해주세요."));
    }

    @ParameterizedTest
    @CsvSource(value = {
            " 1|     2",
            " 3|     4"
    }, delimiter = '|')
    @DisplayName("값이 다른 경우 예외발생 검증")
    void checkSameSize_exception(int size, int targetSize) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Preconditions.checkSameSize(size, targetSize, "동일한 값을 입력해주세요."));
    }

    @Test
    @DisplayName("입력값이 올바른 경우 검증")
    void checkState() {
        assertDoesNotThrow(() -> Preconditions.checkState(true, "결과값이 올바르지 않습니다."));
    }

    @Test
    @DisplayName("입력값이 올바르지 않은 경우 예외발생 검증")
    void checkState_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Preconditions.checkState(false, "결과값이 올바르지 않습니다."));
    }
}
