package ladder.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    void 쉼표_참가자_생성() {
        // given
        String names = "dugi,manse,tomas";

        // then
        Participants participants = new Participants(names);

        // then
        assertThat(participants.size()).isEqualTo(3);
    }
}