package ladder.domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {
    @DisplayName("참여하는 사람에 이름은 공백이나 null일수 없음")
    @Test
    void blankNameTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant(null))
            .withMessage(Participant.ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant(""))
            .withMessage(Participant.ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant(" "))
            .withMessage(Participant.ERROR_MESSAGE_REQUIRED_NAME);
    }

    @DisplayName("참여하는 사람에 이름을 알파벳(a-z), 숫자(0-9)포함 5글자  부여")
    @Test
    void maxLengthNameTest () {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant("1"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant("abcdef"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);
    }
}
