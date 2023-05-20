package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Participants;
import nextstep.domain.Record;
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

    @Test
    void 참가자들_기록_반환() {

        // given
        Participants participate = Participants.participate("abc", "def", "ghi");
        Ladder ladder = Ladder.makeLadder(3, 3, () -> true);
        String[] gameResult = {"1000", "2000", "3000"};

        // when
        Record record = participate.go(ladder, gameResult);

        // then
        assertThat(record.value("abc")).containsValue("2000");
        assertThat(record.value("def")).containsValue("1000");
        assertThat(record.value("ghi")).containsValue("3000");
    }
}
