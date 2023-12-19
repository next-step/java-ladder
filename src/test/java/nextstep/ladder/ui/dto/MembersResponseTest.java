package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.JoinMembers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MembersResponseTest {

    @Test
    void createMembersResponse() {
        JoinMembers joinMembers = new JoinMembers("pobi,honux,crong,jk");

        MembersResponse members = MembersResponse.from(joinMembers);

        assertThat(members.getResponse()).isEqualTo(" pobi honux crong    jk");
    }
}