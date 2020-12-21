package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {

    @Test
    void create() {
        Participants participants = Participants.create("aaa,bbb,ccc");
        assertThat(participants.getParticipantCount()).isEqualTo(3);
    }

    @Test
    @DisplayName(value = "최소 두명의 사람이 필요함.")
    void isLessThanTwoPeople() {
        assertThatThrownBy(() -> Participants.create("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
