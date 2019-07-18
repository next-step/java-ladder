package ladder;

import ladder.domain.LadderLines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
    private static final String TEST_RESULTS_STRING = "꽝, 5000, 10000";

    @DisplayName("ladderHeight 크기 만큼 LadderLine 이 만들어져야 합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testIfGivenLadderHeightThanListSizeEquals(int ladderHeight) {
        int countOfPerson = 3;
        Ladder ladder = Ladder.of(countOfPerson, TEST_RESULTS_STRING, ladderHeight);
        LadderLines ladderLines = ladder.getLadderLines();

        assertThat(ladderLines.size()).isEqualTo(ladderHeight);
    }

    @DisplayName("사람 숫자와 결과 숫자가 일치하지 않으면 예외를 발생합니다.")
    @Test
    public void testIfNotEqualsCountOfPersonAndCountOfRewardThenInvokedException() {
        int countOfPerson = 5;
        int ladderHeight = 5;
        assertThatIllegalStateException().isThrownBy(()-> Ladder.of(countOfPerson, TEST_RESULTS_STRING, ladderHeight));
    }
}
