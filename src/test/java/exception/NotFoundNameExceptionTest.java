package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NotFoundNameExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(NotFoundNameException.class)
                .isThrownBy(() -> {
                    throw new NotFoundNameException();
                });
    }
}
