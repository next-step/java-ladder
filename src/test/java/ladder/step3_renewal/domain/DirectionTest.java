package ladder.step3_renewal.domain;

import org.junit.jupiter.api.Test;
import step3_renewal.domain.Direction;
import step3_renewal.domain.LadderRandomGenerator;

import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    public void 첫번째이동() {
        assertThat(Direction.first(true).next(new LadderRandomGenerator().nextLine())).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void 오른쪽이동() {
        assertThat(Direction.of(true, false).next(true)).isEqualTo(Direction.of(false, true));
    }

    @Test
    public void 왼쪽이동() {
        assertThat(Direction.of(false, true).next(false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void 마지막이동() {
        assertThat(Direction.first(true).last()).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next(new LadderRandomGenerator().nextLine());
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        IntStream.range(0, 100)
                .forEach(i -> Direction.first(FALSE).next(new LadderRandomGenerator().nextLine()));
    }
}
