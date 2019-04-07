package ladder.domain.member;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MemberGroupTest {
    @Test
    public void 참여자가_2명_미만일_경우_IllegalArgumentException() {
        // given
        Member member = new Member("son");

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new MemberGroup(Arrays.asList(member)));
    }

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
