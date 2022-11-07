package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.util.LadderMembersExpression.validateMemberNames;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMembersTest {
    @Test
    @DisplayName("사람의 이름을 쉼표(,)로 기준으로 한만큼 Member 의 수가 만들어진다.")
    void makeMembersCountTest() {
        List<String> memberNames = validateMemberNames("pobi,honux,crong,jk");
        assertThat(new LadderMembers(LadderMembers.addMember(memberNames)).memberCount()).isEqualTo(4);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"pobi", "pobi,", "pobi,,"})
    @DisplayName("Members의 이름 입력이 알맞지 않으면 에러 발생한다. - null (x), 빈문자열(x), 두사람 미만의 이름 입력(x)")
    void inputMembersNameExceptionTest(String input) {
        assertThatThrownBy(() -> new LadderMembers(LadderMembers.addMember(validateMemberNames(input))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
