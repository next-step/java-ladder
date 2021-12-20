package ladder.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    void 쉼표_참가자_생성() {
        // given
        String names = "dugi,manse,tomas";

        // then
        Participants participants = new Participants(names);

        // then
        Assertions.assertThat(participants.size()).isEqualTo(3);
    }
}