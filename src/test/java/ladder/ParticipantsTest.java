package ladder;

import org.junit.jupiter.api.Test;
import ladder.domain.Participants;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    void 참가자_이름_입력_나누기() {
        String input = "pobi,honux,crong,jk";

        Participants participants = new Participants(input);
        assertThat(participants.countOfParticipants()).isEqualTo(4);
    }

    @Test
    void 참가자_위치_찾기() {
        String input = "pobi,honux,crong,jk";
        Participants participants = new Participants(input);
        assertThat(participants.findPosition("crong")).isEqualTo(2);
    }
}
