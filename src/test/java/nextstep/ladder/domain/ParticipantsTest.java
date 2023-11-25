package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    @DisplayName("성공 - 참가자들이 생성된다.")
    void success_generate_participants() {
        List<String> persons = List.of("pobi", "honux", "crong", "jk");

        Participants participants = new Participants(persons);

        assertThat(participants.countOfParticipant()).isEqualTo(4);
    }

}
