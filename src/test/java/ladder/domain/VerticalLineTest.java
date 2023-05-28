package ladder.domain;

import ladder.domain.enums.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerticalLineTest {

    @Test
    void 생성검증() {
        Assertions.assertThat(new VerticalLine(Direction.LEFT)).isInstanceOf(VerticalLine.class);
    }

    @Test
    void 이동검증() {
        VerticalLine hasLeft = new VerticalLine(Direction.LEFT);
        VerticalLine hasRight = new VerticalLine(Direction.RIGHT);
        VerticalLine hasNone = new VerticalLine(Direction.NONE);

        Assertions.assertThat(hasLeft.getNextPosition(1)).isEqualTo(0);
        Assertions.assertThat(hasRight.getNextPosition(1)).isEqualTo(2);
        Assertions.assertThat(hasNone.getNextPosition(1)).isEqualTo(1);
    }
}
