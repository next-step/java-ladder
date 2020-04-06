package ladder;

import ladder.model.Ladder;
import ladder.model.LadderHeight;
import ladder.model.MemberCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 테스트")
public class LadderTests {

    @DisplayName("사다리 생성 테스트")
    @Test
    public void generateLadderTests() {
        assertThatCode(() -> Ladder.newInstance(4, 5, "꽝,5000,꽝,3000")).doesNotThrowAnyException();
        assertThatCode(() -> Ladder.newInstance(new MemberCount(5), LadderHeight.newInstance(3), LadderGameRewords.newInstacne("꽝,5000,꽝,3000,꽝"))).doesNotThrowAnyException();
    }

    @DisplayName("사다리 생성 테스트 - 참가자 수와 LadderPoleResults의 갯수가 맞지 않을 때")
    @Test
    public void generateLadderAbnormalMemberCountWithLadderPoleResultsTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.newInstance(5, 1, "꽝,5000,꽝,3000"))
                .withMessageContaining("Member count is not same as size of LadderGameRewords");
    }

}
