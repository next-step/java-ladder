package ladder.domain.enums;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DirectionTest {

    @Test
    public void 아래로_내려갈_것이다() {
        assertThat(Direction.of(false, false)).isEqualTo(Direction.PASS);
    }

    @Test
    public void 왼쪽으로_이동할_것이다() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.LEFT);
    }
    @Test
    public void 오른쪽으로_이동할_것이다() {
        assertThat(Direction.of(false, true)).isEqualTo(Direction.RIGHT);
    }
}
