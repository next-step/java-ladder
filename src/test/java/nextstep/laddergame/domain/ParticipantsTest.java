package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    void 참여자_이름을_입력하면_참여자_이름이_생성된다() {
        Participants participants = new Participants("A", "B", "C");

        assertThat(participants.participantList().size()).isEqualTo(3);
    }

}