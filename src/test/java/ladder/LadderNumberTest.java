package ladder;

import ladder.domain.LadderNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderNumberTest {

    @Test
    @DisplayName("left right ladderNumber 정상 이동 되는지 테스트")
    void left_right() {
        int number = 2;
        LadderNumber currentLadderNumber = new LadderNumber(number);

        assertThat(currentLadderNumber.leftLadderNumber()).isEqualTo(new LadderNumber(number - 1));
        assertThat(currentLadderNumber.rightLadderNumber()).isEqualTo(new LadderNumber(number + 1));
    }

}
