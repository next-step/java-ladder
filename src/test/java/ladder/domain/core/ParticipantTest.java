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

    static class Participant {
        public static final String ERROR_MESSAGE_REQUIRED_NAME = "참여하는 사람의 이름을 지정해 주세요.";
        public static final String ERROR_MESSAGE_SUITABLE_NAME = "참여하는 사람의 이름은 알파벳(a-z), 숫자(0-9)포함 5글자 입니다.";
        public static final String REGEX_SUITABLE_NAME = "[a-z][a-z0-9]{0,4}";

        Participant(String name) {
            verifyBlankName(name);
            verifySuitableName(name);
        }

        private void verifySuitableName(String name) {
            if (!name.matches(REGEX_SUITABLE_NAME)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_SUITABLE_NAME);
            }
        }

        private void verifyBlankName(String name) {
            if (null == name || "".equals(name.trim())){
                throw new IllegalArgumentException(ERROR_MESSAGE_REQUIRED_NAME);
            }
        }
    }
}
