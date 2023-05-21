package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {

    private List<String> participants;

    @BeforeEach
    void setUp() {
        this.participants = List.of("a", "b", "c", "d", "e");
    }

    @DisplayName("참여자가 2명 미만일 경우 예외를 발생한다.")
    @Test
    void when_ParticipantsAreUnderTwo_Expects_ThrowException() {
        List<String> participants = List.of("pobi");

        assertThatThrownBy(() -> new Participants(participants))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자의 이름이 5글자를 초과할 경우 예외를 발생한다.")
    @Test
    void when_ParticipantNameLengthIsOverFive_Expects_ThrowException() {
        List<String> participants = List.of("a", "bb", "ccc", "dddd", "eeeee", "ffffff");

        assertThatThrownBy(() -> new Participants(participants))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자의 수를 반환한다")
    @Test
    public void when_CallingNumberMethod_Expects_returnParticipantsNumber() {
        Participants participants = new Participants(this.participants);
        assertThat(participants.number()).isEqualTo(5);
    }

    @DisplayName("입력받은 값이 참여자 리스트에 포함되면 예외를 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e"})
    void when_ParticipantListContainsName_Expects_returnFalse(String name) {
        Participants participants = new Participants(this.participants);

        assertThatNoException()
                .isThrownBy(() -> participants.validateResultInput(name));
    }

    @DisplayName("입력받은 이름이 참여자 리스트에 포함되지 않으면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"g", "h", "i", "j", "k"})
    void when_ParticipantListIsNotContainingName_Expects_returnTrue(String name) {
        Participants participants = new Participants(this.participants);

        assertThatThrownBy(() -> participants.validateResultInput(name))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("참여자 리스트에서 입력받은 이름의 인덱스를 반환한다")
    @Test
    public void when_NameIsGiven_Expects_ReturnItsIndex() {
        Participants participants = new Participants(this.participants);

        assertThat(participants.indexOf("b")).isEqualTo(1);
    }

    @DisplayName("참여자 리스트의 최대 인덱스를 반환한다.")
    @Test
    void maxIndex() {
        Participants participants = new Participants(this.participants);

        assertThat(participants.maxIndex()).isEqualTo(4);
    }

    @DisplayName("입력한 값과 길이가 같으면 false를 반환한다.")
    @Test
    void test1() {
        Participants participants = new Participants(this.participants);

        assertThat(participants.isNotSameNum(this.participants.size()))
                .isFalse();
    }

    @DisplayName("입력한 값과 길이가 같지 않으면 true를 반환한다.")
    @Test
    void test2() {
        Participants participants = new Participants(this.participants);

        assertThat(participants.isNotSameNum(this.participants.size() - 1))
                .isTrue();
    }
}
