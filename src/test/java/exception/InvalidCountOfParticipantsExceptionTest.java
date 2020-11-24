package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InvalidCountOfParticipantsExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(InvalidCountOfParticipantsException.class)
                .isThrownBy(() -> {
                    throw new InvalidCountOfParticipantsException();
                });
    }

}
