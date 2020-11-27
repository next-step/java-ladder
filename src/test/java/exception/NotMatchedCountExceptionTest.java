package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NotMatchedCountExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(NotMatchedCountException.class)
                .isThrownBy(() -> {
                    throw new NotMatchedCountException();
                });
    }
}
