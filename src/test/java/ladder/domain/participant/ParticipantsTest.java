package ladder.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    @DisplayName("Participants 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        String[] names = "a,b,c".split(",");

        // when
        Participants participants = Participants.of(names);

        // then
        assertThat(participants).isNotNull();
    }
}