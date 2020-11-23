package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OutOfNameLengthExceptionTest {
    @Test
    void test() {
        assertThatExceptionOfType(OutOfNameLengthException.class)
                .isThrownBy(() -> {
                    throw new OutOfNameLengthException();
                });
    }
}
