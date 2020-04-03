package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 테스트")
public class LadderTests {

    @DisplayName("사다리 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,4", "4,5"})
    public void generateLadderTests(final int memberCount, final int ladderHeight) {
        assertThatCode(() -> Ladder.newInstance(memberCount, ladderHeight));
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
