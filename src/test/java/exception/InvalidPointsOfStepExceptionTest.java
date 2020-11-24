package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InvalidPointsOfStepExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(InvalidPointsOfStepException.class)
                .isThrownBy(() -> {
                    throw new InvalidPointsOfStepException();
                });
    }
}
