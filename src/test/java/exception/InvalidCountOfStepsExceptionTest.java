package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InvalidCountOfStepsExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(InvalidCountOfStepsException.class)
                .isThrownBy(() -> {
                    throw new InvalidCountOfStepsException();
                });
    }
}
