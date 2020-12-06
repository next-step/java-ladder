package ladder.direction;

import ladder.model.move.Direction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    void 이동_값_확인(){
        assertThat(Direction.LEFT.getStep()).isEqualTo(-1);
        assertThat(Direction.RIGHT.getStep()).isEqualTo(1);
    }
}
