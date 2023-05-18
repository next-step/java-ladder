package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("입력받은 이름이 all이면 예외를 발생하지 않는다")
    @Test
    void when_InputNameIsAll_Expects_DoesNotThrowException() {
        Participants participants = new Participants("a,b,c,d,e");

        assertThatNoException()
                .isThrownBy(() -> participants.contains("all"));
    }

    @DisplayName("입력받은 이름이 참여자 리스트에 포함되면 예외를 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e"})
    void when_ParticipantListContainsName_Expects_DoesNotThrowException(String name) {
        Participants participants = new Participants("a,b,c,d,e");

        assertThatNoException()
                .isThrownBy(() -> participants.contains(name));
    }

    @DisplayName("입력받은 이름이 참여자 리스트에 포함되지 않으면 예외를 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"g", "h", "i", "j", "k"})
    void when_ParticipantListDoesNotContainsName_Expects_ThrowException(String name) {
        Participants participants = new Participants("a,b,c,d,e");

        assertThatThrownBy(() -> participants.contains(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}