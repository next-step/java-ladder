package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MovingStrategyTest {

    private LadderRow line1;
    private LadderRow line2;

    @BeforeEach
    void setUp() {
        line1 = new LadderRow(Arrays.asList(true, false, false));
        line2 = new LadderRow(Arrays.asList(false, true, false));
    }

    @Test
    @DisplayName("상황에 맞게 움직일 수 있는지(move) 확인한다.")
    void move_ExactlyMove_PositionValueCorrect() {
        int position = 0;

        position = MovingStrategy.move(line1, position);
        Assertions.assertThat(position).isEqualTo(1);

        position = MovingStrategy.move(line2, position);
        Assertions.assertThat(position).isEqualTo(2);
    }
}
