package domain.ladder;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void test_이동방향() {
        List<Boolean> lines = Arrays.asList(false, true, false, true, false);

        assertThat(Direction.generate(lines, 0))
                .isEqualTo(Direction.RIGHT);
        assertThat(Direction.generate(lines, 1))
                .isEqualTo(Direction.LEFT);
        assertThat(Direction.generate(lines, 2))
                .isEqualTo(Direction.RIGHT);
        assertThat(Direction.generate(lines, 3))
                .isEqualTo(Direction.LEFT);
        assertThat(Direction.generate(lines, 4))
                .isEqualTo(Direction.DOWN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_이동방향_에러_음수값() {
        List<Boolean> lines = Arrays.asList(false, true, false, true, false);
        Direction.generate(lines, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_이동방향_에러_길이초과() {
        List<Boolean> lines = Arrays.asList(false, true, false, true, false);
        Direction.generate(lines, 5);
    }
}