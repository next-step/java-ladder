package ladder;

import ladder.model.Member;
import ladder.model.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 게임 참여자 테스트")
public class MemberTests {

    @DisplayName("참여자 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"paul", "abc", "x"})
    public void generateMemberTests(final String name) {
        assertThatCode(() -> Member.of(name)).doesNotThrowAnyException();
    }

    @DisplayName("참여자 생성 테스트 - 비정상")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"paulabc", "   "})
    public void generateMemberAbnormalTests(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Member.of(name))
                .withMessageContaining("Member name must be exist and the length must be less than 5.");
    }

    @DisplayName("참여자 복수 생성 테스트")
    @Test
    public void generateMembersTests() {
        List<Member> members = Arrays.asList(Member.of("abc"), Member.of("bcd"));
        assertThatCode(() -> Members.newInstance(members)).doesNotThrowAnyException();
    }

    @DisplayName("참여자 복수 생성 테스트 - 비정상")
    @Test
    public void generateMembersAbnormalTests() {
        List<Member> members = Collections.emptyList();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Members.newInstance(members))
                .withMessageContaining("Member must be existed.");
    }
}
