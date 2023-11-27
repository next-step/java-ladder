package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @DisplayName("참가자가 2명보다 적다면 예외발생")
    @Test
    void getParticipant() {
        assertThatThrownBy(()-> new Participant("choi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 2명 이상 참가해야됩니다.");
    }

    @DisplayName("참가자의 수를 리턴한다.")
    @Test
    void size() {
        assertThat(new Participant("choi, jae, hyeon").size()).isEqualTo(3);
    }

}