package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InvalidCountOfNamesExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(InvalidCountOfNamesException.class)
                .isThrownBy(() -> {
                    throw new InvalidCountOfNamesException();
                });
    }

}
