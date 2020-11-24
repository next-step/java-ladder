package exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DuplicatedParticipantsNameExceptionTest {
    @Test
    void test() {
        assertThatExceptionOfType(DuplicatedParticipantsNameException.class)
                .isThrownBy(() -> {
                    throw new DuplicatedParticipantsNameException();
                });
    }
}
