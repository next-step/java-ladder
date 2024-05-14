package nextstep.version.refactor.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {


    @DisplayName("','구분자를 이용해 이름 리스트를 만들어 참가자를 생성할 수 있다.")
    @Test
    void createParticipant() {
        Participants participants = new Participants("pobi,bob");
        Participant participant = participants.get(0);
        Assertions.assertThat(participant).isEqualTo(new Participant("pobi"));

        Participant participant1 = participants.get(1);
        Assertions.assertThat(participant1).isEqualTo(new Participant("bob"));
    }
}
