package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @DisplayName("참여자 생성 테스트")
    @Test
    void create_참여자() {
        // given
        Participants participants = Participants.valueOf("user1", "user2", "user3");
        // when
        Participants expected = Participants.valueOf("user1", "user2", "user3");
        // then
        assertThat(participants).isEqualTo(expected);
    }

}
