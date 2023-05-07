package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    @DisplayName("참여자는 사용자 수를 반환한다.")
    void test01() {
        List<String> expected = Arrays.asList("pobi", "honux", "crong", "jk");
        String input = String.join(",", expected);

        Participants participants = Participants.of(input);

        assertThat(participants.count()).isEqualTo(expected.size());
    }

}
