package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NotAPositiveStepsOfLadderExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(NotAPositiveStepsOfLadderException.class)
                .isThrownBy(() -> {
                    throw new NotAPositiveStepsOfLadderException();
                });
    }
}
