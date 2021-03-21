package ladder;

import ladder.domain.LadderNumber;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderNumberTest {

    @Test
    @DisplayName("next시 왼쪽에 연결된 다음 사다리 있을시 이동 되는지 테스트")
    void next_to_left() {
        int number = 2;
        LadderNumber currentLadderNumber = new LadderNumber(number);
        Line line = Line.of(Arrays.asList(new Point(false), new Point(false), new Point(true)));
        LadderNumber next = currentLadderNumber.next(line);
        LadderNumber leftLadderNumber = new LadderNumber(number -1);

        assertThat(next).isEqualTo(leftLadderNumber);
    }

    @Test
    @DisplayName("next시 오른쪽에 연결된 다음 사다리 있을시 이동 되는지 테스트")
    void next_to_right() {
        int number = 1;
        LadderNumber currentLadderNumber = new LadderNumber(number);
        Line line = Line.of(Arrays.asList(new Point(false), new Point(false), new Point(true)));
        LadderNumber next = currentLadderNumber.next(line);
        LadderNumber rightLadderNumber = new LadderNumber(number + 1);

        assertThat(next).isEqualTo(rightLadderNumber);
    }


    @Test
    @DisplayName("next시 연결된 라인이 없을시 그대로 인지 테스트")
    void next_same() {
        int number = 2;
        LadderNumber currentLadderNumber = new LadderNumber(number);
        Line line = Line.of(Arrays.asList(new Point(false), new Point(false), new Point(false)));
        LadderNumber next = currentLadderNumber.next(line);
        LadderNumber leftLadderNumber = new LadderNumber(number);

        assertThat(next).isEqualTo(leftLadderNumber);
    }


}
