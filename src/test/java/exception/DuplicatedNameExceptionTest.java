package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DuplicatedNameExceptionTest {
    @Test
    void test() {
        assertThatExceptionOfType(DuplicatedNameException.class)
                .isThrownBy(() -> {
                    throw new DuplicatedNameException();
                });
    }
}
