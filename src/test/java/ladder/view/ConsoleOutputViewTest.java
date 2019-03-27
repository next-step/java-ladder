package ladder.view;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleOutputViewTest {
    @Test
    public void 화면에_표시_될_MemberGroup_테스트() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        Member son = new Member("son");
        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong, son));

        // when
        String memberGroupString = ConsoleOutputView.getMemberGroupString(memberGroup);

        // then
        assertThat(memberGroupString).isEqualTo("pobi     crong     son");
    }
}
