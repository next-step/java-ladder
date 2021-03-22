package ladder;

import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("left right ladderNumber 정상 이동 되는지 테스트")
    void left_right() {
        int number = 2;
        Position currentPosition = new Position(number);

        assertThat(currentPosition.leftLadderNumber()).isEqualTo(new Position(number - 1));
        assertThat(currentPosition.rightLadderNumber()).isEqualTo(new Position(number + 1));
    }

}
