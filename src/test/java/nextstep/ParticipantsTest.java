package nextstep;

import nextstep.domain.Participants;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    void 참여자들_수_반환() {

        // given
        Participants participate = Participants.participate("abc", "def", "ghi");

        // when
        int result = participate.count();

        // then
        assertThat(result).isEqualTo(3);
    }
}
