package nextstep.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantTest {

    @DisplayName("이름은 5글자를 넘길 수 없다.")
    @Test
    void maxLengthIsFive() {
        assertThatThrownBy(() -> new Participant("다섯글자넘기"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5글자 미만이면 공백으로 채운다.")
    @Test
    void getName() {
        Participant participant = new Participant("test");
        assertThat(participant.getName()).isEqualTo(" test");
    }
}
