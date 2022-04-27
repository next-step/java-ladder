package ladder.model;

import ladder.exception.InvalidUsernameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @Test
    @DisplayName("사용자 이름 길이가 5이하이면 정상적으로 생성된다")
    void create() {
        assertThat(Participant.create("next")).isInstanceOf(Participant.class);
    }

    @Test
    @DisplayName("사용자 이름의 길이가 5이상일 경우 예외를 발생시킨다")
    void throwInvalidUsernameException() {
        assertThatThrownBy(() -> Participant.create("cooper")).isInstanceOf(InvalidUsernameException.class);
    }

}