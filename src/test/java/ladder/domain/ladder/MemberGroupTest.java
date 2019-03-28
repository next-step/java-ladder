package ladder.domain.ladder;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberGroupTest {
    @Test
    public void toString_공백_5글자_기준_확인() {
        // given
        Member pobi = new Member("pobi");
        Member crong = new Member("crong");
        Member son = new Member("son");

        MemberGroup memberGroup = new MemberGroup(Arrays.asList(pobi, crong, son));

        // when
        String memberGroupString = memberGroup.toString();

        // then
        assertThat(memberGroupString).isEqualTo("pobi crong   son");
    }
}
