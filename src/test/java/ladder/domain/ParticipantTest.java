package ladder.domain;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "A", "a", "aa", "aaa", "aaaa", "aaaaa"})
    @DisplayName("정상적인 이름을 승인할 수 있다")
    void vefifiesValidNames(String inputString) {
        Participant participant = new Participant(inputString);
        assertThat(participant.name()).isEqualTo(inputString.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "!", "가"})
    @DisplayName("알파벳이 아닐 경우 INVALID_PARTICIPANTS_INPUT 에러를 던진다")
    void nonAlphabeticalInputThrowsException(String inputString) {
        CustomException thrown = assertThrows(CustomException.class, () -> new Participant(inputString));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_PARTICIPANTS_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdfgh", "longName", "INVALID,PARTICIPANTS,NAME"})
    @DisplayName("알파벳이 아닐 경우 INVALID_PARTICIPANTS_NAME 에러를 던진다")
    void abnormallyLongNameThrowsException(String inputString) {
        CustomException thrown = assertThrows(CustomException.class, () -> new Participant(inputString));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_PARTICIPANTS_NAME);
    }
}
