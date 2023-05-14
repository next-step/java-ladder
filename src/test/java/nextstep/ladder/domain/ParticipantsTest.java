package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {
    @Test
    @DisplayName("csv 문자열로 입력된 사용자 이름으로 Participants 객체 생성")
    void create_by_CSV_String() {
        // given
        String participantsName = "foo, bar , baz";

        // when
        Participants participants = new Participants(participantsName);

        // then
        Participants expectedParticipants = new Participants("foo", "bar", "baz");
        assertThat(participants).isEqualTo(expectedParticipants);
    }
}