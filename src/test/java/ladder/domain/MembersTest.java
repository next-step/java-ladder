package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MembersTest {

    @Test
    void 게임_참여자_수_확인() {
        Members members = new Members("aaaa", "bbb", "cc");
        assertThat(members.countOfMembers()).isEqualTo(3);
    }
}
