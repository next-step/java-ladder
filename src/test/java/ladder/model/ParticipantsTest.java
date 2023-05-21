package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ParticipantsTest {

    @Test
    @DisplayName("참여자수 테스트")
    void countTest() {
        // given
        String[] names = "pobi,honux,crong,jk".split(",");
        Participants participants = new Participants(names);

        // when
        int actual = participants.count();

        // then
        assertThat(actual).isEqualTo(4);
    }
}