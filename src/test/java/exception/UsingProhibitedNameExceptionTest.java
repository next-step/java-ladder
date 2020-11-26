package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UsingProhibitedNameExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(UsingProhibitedNameException.class)
                .isThrownBy(() -> {
                    throw new UsingProhibitedNameException();
                });
    }
}
