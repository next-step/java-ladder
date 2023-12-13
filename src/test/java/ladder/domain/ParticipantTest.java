package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantTest {

    @DisplayName("1자 이상, 5자 이하의 참가자 이름을 전달하면 Participant 객체를 생성한다.")
    @Test
    void participantTest() {
        assertThat(new Participant("1")).isInstanceOf(Participant.class);
        assertThat(new Participant("다섯글자다")).isInstanceOf(Participant.class);
    }

    @DisplayName("null 또는 1자 이하 또는 5자 이상의 참가자 이름을 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void participantExceptionTest() {
        assertThatThrownBy(() -> new Participant(null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Participant(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Participant("여섯글자이름"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자의 이름 길이를 알 수 있다.")
    @Test
    void lengthTest() {
        Participant participant = new Participant("테스트이름");

        assertThat(participant.length()).isEqualTo(5);
    }
}
