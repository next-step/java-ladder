package nextstep.ladder.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    @DisplayName("여러 String 값을 입력 받아 Participants 객체를 생성한다")
    void shouldCreate() {
        String input = "pobi,honux,crong,jk";
        Participants participants = Participants.from(input);

        assertThat(participants).isEqualTo(Participants.from(input));
    }
}