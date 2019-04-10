package ladder.parser;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberParserTest {
    @Test
    public void 문자열을_Member_객체로_변환() {
        // given
        String pobi = "pobi";

        // when
        Member member = MemberParser.parseMember(pobi);

        // then
        assertThat(member.getName()).isEqualTo(pobi);
    }

    @Test
    public void 문자열을_MemberGroup_으로_변환() {
        // given
        String pobi = "pobi";
        String crong = "crong";
        String son = "son";
        String memberNames = String.join(", ", pobi, crong, son);

        // when
        MemberGroup parsedMemberGroup = MemberParser.parseMemberGroup(memberNames);

        // then
        List<Member> parsedMembers = parsedMemberGroup.getMembers();
        assertThat(parsedMembers).containsExactly(new Member(pobi), new Member(crong), new Member(son));
    }
}
