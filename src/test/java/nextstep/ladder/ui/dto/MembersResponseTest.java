package nextstep.ladder.ui.dto;

import nextstep.ladder.domain.JoinMembers;
import org.junit.jupiter.api.Test;

import java.util.List;

class MembersResponseTest {

    @Test
    void test() {
        // given
        JoinMembers joinMembers = JoinMembers.from(List.of("pobi,honux,crong,jk".split(",")));

        // when
        MembersResponse member = MembersResponse.from(joinMembers);

        //



    }
}