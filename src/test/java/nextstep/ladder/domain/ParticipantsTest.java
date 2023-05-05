package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    private List<String> expected;
    private String input;

    @BeforeEach
    void setUp() {
        expected = Arrays.asList("pobi", "honux", "crong", "jk");
        input = String.join(",", expected);
    }

    @Test
    @DisplayName("참여자는 사용자 이름을 반환한다.")
    void test01() {
        Participants participants = Participants.of(input);

        assertThat(participants.getUserNames()).isEqualTo(expected);
    }

    @Test
    @DisplayName("참여자는 사용자 수를 반환한다.")
    void test02() {
        Participants participants = Participants.of(input);

        assertThat(participants.count()).isEqualTo(expected.size());
    }

}
