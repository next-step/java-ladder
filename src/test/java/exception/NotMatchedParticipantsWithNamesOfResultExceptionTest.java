package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NotMatchedParticipantsWithNamesOfResultExceptionTest {

    @Test
    void test() {
        assertThatExceptionOfType(NotMatchedParticipantsWithNamesOfResultException.class)
                .isThrownBy(() -> {
                    throw new NotMatchedParticipantsWithNamesOfResultException();
                });
    }
}
