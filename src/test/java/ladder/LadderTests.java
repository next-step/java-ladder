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
        assertThatCode(() -> Ladder.newInstance(4, 5)).doesNotThrowAnyException();
        assertThatCode(() -> Ladder.newInstance(new MemberCount(5), LadderHeight.newInstance(3))).doesNotThrowAnyException();
    }

    @DisplayName("사다리 생성 테스트 - 참가자 수 비정상")
    @Test
    public void generateLadderAbnormalMemberCountTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.newInstance(-13, 1))
                .withMessageContaining("Member count must be greater than zero.");
    }

    @DisplayName("사다리 생성 테스트 - 사다리 높이 비정상")
    @Test
    public void generateLadderAbnormalLadderHeightTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.newInstance(1, -13))
                .withMessageContaining("Ladder height must be greater than zero.");
    }
}
