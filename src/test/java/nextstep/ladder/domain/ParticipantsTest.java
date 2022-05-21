package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ParticipantsTest {

    @Test
    @DisplayName("입력된 참가자의 수만큼 Participant 객체가 생성된다.")
    void createdParticipantObjectTheNumberOfInputValue() {
        // given
        String[] names = new String[]{"a", "b", "c"};

        // when
        Participants participants = new Participants(names);

        // then
        assertThat(participants.getValues()).hasSize(names.length);
    }

    @ParameterizedTest(name = "입력된 참가자 리스트가 null 또는 empty인 경우 예외처리를 한다.")
    @NullAndEmptySource
    void exceptionParticipantsNullOrEmpty(String[] names) {
        // when & then
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "결과를 보고싶은 참가자 {0}의 위치는 {1}이다")
    @CsvSource({"a,0", "b,1", "c,2", "d,3"})
    void checkedParticipantPosition(String participant, int expected) {
        // given
        String[] names = new String[]{"a", "b", "c", "d"};
        Participants participants = new Participants(names);

        // when
        int findPosition = participants.findPosition(participant);

        // then
        assertThat(findPosition).isEqualTo(expected);
    }
}
