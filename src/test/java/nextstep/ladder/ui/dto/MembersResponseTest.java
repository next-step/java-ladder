package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.JoinMembers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MembersResponseTest {

    @Test
    void createMembersResponse() {
        // given
        JoinMembers joinMembers = JoinMembers.from(List.of("pobi,honux,crong,jk".split(",")));

        // when
        MembersResponse members = MembersResponse.from(joinMembers);

        // then
        assertThat(members.getResponse()).isEqualTo(" pobi honux crong    jk");
    }
}