package ladder.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 참가자_1명_이하이면_예외() {
        // then
        assertThatThrownBy(() -> new Participants("dugi,"))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자가 2명 이상이어야 게임을 진행할 수 있습니다.");
    }
}