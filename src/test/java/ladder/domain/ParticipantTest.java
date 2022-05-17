package ladder.domain;

import ladder.exception.InvalidParticipantNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcd", "abcde"})
    @DisplayName("사용자의 이름이 1글자 이상 5글자 이하이면 참가자가 생성된다.")
    void createParticipantTest(String inputName) {
        Participant participant = new Participant(inputName);
        assertThat(participant.getName()).isEqualTo(inputName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "abcabc", "abcdabcd", ""})
    @DisplayName("사용자의 이름이 비었거나 6글자 이상이면 InvalidParticipantNameException 발생")
    void throwInvalidParticipantNameExceptionTest(String inputName) {
        assertThatThrownBy(() -> new Participant(inputName))
                .isInstanceOf(InvalidParticipantNameException.class);
    }
}