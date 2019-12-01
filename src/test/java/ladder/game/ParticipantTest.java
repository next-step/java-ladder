package ladder.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {
    @ParameterizedTest
    @ValueSource(strings = "이름이 매우 길어서, 예외가 발생하는 경우")
    @DisplayName("이름이 긴 사용자를 입력할 때 예외 발생")
    void constructorExceptionTest(String participant) {
        assertThrows(IllegalArgumentException.class, () -> new Participant(participant));
    }

    @Test
    void constructorTest() {
        assertThat(new Participant("참여자"))
                .isEqualTo(new Participant("참여자"));
    }
}