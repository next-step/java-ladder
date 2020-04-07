package ladder;

import ladder.model.Member;
import ladder.model.MemberCount;
import ladder.model.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("MemberCount 테스트")
public class MemberCountTests {

    @DisplayName("Members 카운트 생성테스트")
    @Test
    public void generateMembersCountTests() {
        assertThatCode(() -> MemberCount.of(3)).doesNotThrowAnyException();
    }

    @DisplayName("Members 카운트 생성 실패 테스트")
    @Test
    public void generateMembersCountFailTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MemberCount.of(-3))
                .withMessageContaining("Member count must be greater than zero.");
    }

    @DisplayName("Members 카운트 비교 테스트")
    @Test
    public void comapreMembersCountTests() {
        Members members = Members.newInstance(Arrays.asList(Member.of("abc"), Member.of("bcd")));

        assertThat(members.count()).isEqualTo(MemberCount.of(2));
    }
}
