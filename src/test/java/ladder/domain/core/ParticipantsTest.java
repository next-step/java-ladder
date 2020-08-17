package ladder.domain.core;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;
import static ladder.domain.core.Participant.verifyBlankName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @DisplayName("참가자들는 쉼표를 기준으로 공백이나 null일수 없음")
    @Test
    void blankParticipantsTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants(null))
            .withMessage(Participant.ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants(" "))
            .withMessage(Participant.ERROR_MESSAGE_REQUIRED_NAME);
    }

    @DisplayName("잘못된 참가자 이름이 있는 경우 예외 처리")
    @Test
    void suitableNameCheckTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants("123"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants("a12345"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);
    }


    @DisplayName("참가자들는 쉼표를 기준으로 구분함")
    @Test
    void participantsTest() {
        assertThat(new Participants("pobi,honux,crong,jk").getCount()).isEqualTo(4);
    }

    static class Participants {
        public static final String SEPARATOR = ",";
        private final List<Participant> participants;
        public Participants(String participants) {
            verifyBlankName(participants);
            List<Participant> participantList = Stream.of(participants.split(SEPARATOR))
                                              .map(Participant::new)
                                              .collect(toList())
                ;
            this.participants = Collections.unmodifiableList(participantList);
        }

        public int getCount() {
            return participants.size();
        }
    }
}
