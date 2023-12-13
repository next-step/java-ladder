package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ParticipantTest {

    @DisplayName("1자 이상, 5자 이하의 참가자 이름을 전달하면 Participant 객체를 생성한다.")
    @Test
    void participantTest() {
        assertThat(new Participant("1")).isInstanceOf(Participant.class);
        assertThatNoException().isThrownBy(() -> new Participant("다섯글자다"));
    }

    @ParameterizedTest
    @DisplayName("null 또는 1자 이하 또는 5자 이상의 참가자 이름을 전달하면 IllegalArgumentException을 던진다.")
    @NullSource
    @ValueSource(strings = {"", "여섯글자이름"})
    void participantExceptionTest(String input) {
        System.out.println("input :" + input);
        assertThatThrownBy(() -> new Participant(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자의 이름 길이를 알 수 있다.")
    @Test
    void lengthTest() {
        Participant participant = new Participant("테스트이름");

        assertThat(participant.length()).isEqualTo(5);
    }
}
