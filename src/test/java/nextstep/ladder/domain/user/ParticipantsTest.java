package nextstep.ladder.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    private final List<String> users = List.of("pobi", "honux", "crong", "jk");
    private Participants participants;

    @BeforeEach
    void setUp() {
        String input = String.join(",", users);
        participants = Participants.of(input);
    }

    @Test
    @DisplayName("참여자는 사용자 수를 반환한다.")
    void test01() {
        assertThat(participants.count()).isEqualTo(users.size());
    }

    @Test
    @DisplayName("사용자 이름을 입력하면 참여순서를 반환한다.")
    void test02() {
        String user = "crong";
        int expected = users.indexOf(user);
        assertThat(participants.userLocation(UserName.add(user))).isEqualTo(expected);
    }

}
