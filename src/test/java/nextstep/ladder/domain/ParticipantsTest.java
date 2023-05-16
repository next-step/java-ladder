package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @DisplayName("참여자가 2명 미만일 경우 예외를 발생한다.")
    @Test
    void when_ParticipantsAreUnderTwo_Expects_ThrowException() {
        assertThatThrownBy(() -> new Participants("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자의 이름이 5글자를 초과할 경우 예외를 발생한다.")
    @Test
    void when_ParticipantNameLengthIsOverFive_Expects_ThrowException() {
        assertThatThrownBy(() -> new Participants("a,bb,ccc,dddd,eeeee,ffffff"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자의 수를 반환한다")
    @Test
    public void when_CallingNumberMethod_Expects_returnParticipantsNumber() {
        Participants participants = new Participants("a,b,c,d,e");
        assertThat(participants.number()).isEqualTo(5);
    }
}