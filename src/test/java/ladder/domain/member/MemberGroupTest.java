package ladder.domain.member;

import org.junit.Test;

import java.util.Arrays;

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
}
