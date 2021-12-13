package nextstep.ladder.utils;

import static nextstep.ladder.utils.IntegerUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerUtilsTest {


    @Test
    @DisplayName("Input 값이, 양수인 경우 동일한 값이 반환된다.")
    void getNumberIfPositiveTest() {
        assertThat(getNumberIfPositive(10)).isEqualTo(10);
    }

    @ValueSource(ints = {0, -1})
    @ParameterizedTest(name = "[{argumentsWithNames}] Input 값이 양수가 아닌경우, RuntimeException 이 발생한다.")
    void getNumberIfPositiveExceptionTest(int input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> getNumberIfPositive(input));
    }

    @Test
    @DisplayName("Input 값이, 0이상인 경우, 동일한 값이 반환된다.")
    void getNumberIfNotNegativeTest() {
        assertThat(getNumberIfNotNegative(10)).isEqualTo(10);
        assertThat(getNumberIfNotNegative(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("Input 값이 음수인 경우, RuntimeException이 발생한다.")
    void getNumberIfNotNegativeExceptionTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> getNumberIfNotNegative(-1));
    }
}