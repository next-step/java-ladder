package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderMembersTest {
    @Test
    @DisplayName("사람의 이름을 쉼표(,)로 기준으로 한만큼 Member 의 수가 만들어진다.")
    void makeMembersCountTest() {
        assertThat(new LadderMembers("pobi,honux,crong,jk").memberCount()).isEqualTo(4);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사람의 이름을 쉼표(,)로 기준으로 한만큼 Member 의 수가 만들어진다.")
    void inputMembersNameExceptionTest(String input) {
        assertThatThrownBy(() -> new LadderMembers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사람의 이름을 입력하지 않아 사다리 게임을 시작할 수 없습니다. 다시 입력을 해주세요.");
    }
}
