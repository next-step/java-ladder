package ladder;

import ladder.model.LadderGameExecutionInfo;
import ladder.model.LadderGameRewords;
import ladder.model.Members;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameExecutionInfoTests {

    private Members members;

    @BeforeEach
    void init() {
        members = Members.newInstance(new String[]{"a", "b", "c", "d", "e"});
    }

    @DisplayName("사다리 게임 실행 정보 생성 테스트")
    @Test
    public void generateLadderTests() {
        assertThatCode(() -> LadderGameExecutionInfo.newInstance(members, LadderGameRewords.newInstance("꽝,5000,꽝,3000,2000")))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 정보 테스트 - 참가자 수와 LadderGameRewords의 갯수가 맞지 않을 때")
    @Test
    public void generateLadderGameExecutionInfoAbnormalTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGameExecutionInfo.newInstance(members, LadderGameRewords.newInstance("꽝,5000,꽝,3000")))
                .withMessageContaining("members count and ladderGameRewords count must be same.");
    }
}
