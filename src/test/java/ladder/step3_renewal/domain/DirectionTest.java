package ladder.step3_renewal.domain;

import org.junit.jupiter.api.Test;
import step3_renewal.domain.Direction;
import step3_renewal.utils.LadderUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void 첫번째이동() {
        assertThat(Direction.first(true).next(LadderUtil.isLine())).isEqualTo(Direction.of(true, false));
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
}
