package ladder.parser;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberParserTest {
    @Test
    public void 문자열을_MemberGroup_으로_변환() {
        // given
        String members = "pobi, crong, son";

        // when
        MemberGroup memberGroup = MemberParser.parseMemberGroup(members);

        // then
        assertThat(memberGroup.getMembers()).hasSize(3);
    }

    @Test
    public void 문자열을_Member_list_로_변환() {
        // given
        String pobi = "pobi";
        String crong = "crong";
        String son = "son";
        String memberNames = String.join(", ", pobi, crong, son);

        // when
        List<Member> members = MemberParser.parseMembers(memberNames);

        // then
        List<String> memberNamesOfMembers = members.stream()
                .map(Member::getName)
                .collect(Collectors.toList());
        assertThat(memberNamesOfMembers).containsExactly(pobi, crong, son);
    }
}
