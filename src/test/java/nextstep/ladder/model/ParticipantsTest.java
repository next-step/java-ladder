package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    @DisplayName("참석자 이름 입력했을 때 생성하는 검증 로직")
    void 참가자_생성() {
        Participants participants = Participants.from("lee,kim,oh");

        assertThat(participants).isEqualTo(Participants.from("lee,kim,oh"));
    }
}
