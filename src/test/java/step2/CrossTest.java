package step2;

import org.junit.jupiter.api.Test;
import step2.model.Cross;
import step2.model.Direction;

import static org.assertj.core.api.Assertions.*;

public class CrossTest {
    @Test
    public void 오른쪽으로_움직이기() {
        assertThat(Cross.move(0, Direction.RIGHT)).isEqualTo(1);
    }

    @Test
    public void 왼쪽으로_움직이기() {
        assertThat(Cross.move(1, Direction.LEFT)).isEqualTo(0);
    }

    @Test
    public void 아래로_움직이기() {
        assertThat(Cross.move(0, Direction.DOWN)).isEqualTo(0);
    }
}
