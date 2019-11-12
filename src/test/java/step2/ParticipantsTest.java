package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    void 참가자_이름_입력_나누기() {
        String input = "pobi,honux,crong,jk";

        Participants participants = new Participants(input);
        assertThat(participants.countOfParticipants()).isEqualTo(4);
    }


}
