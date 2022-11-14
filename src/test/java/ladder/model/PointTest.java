package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    public void 사다리_마지막_다리_검증() {
        Direction result = createPoint(false, true).last().getDirection();

        Direction expected = new Direction(true, false);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void 사다리_연결_불가능_검증() {
        Direction result = createPoint(false, true).next(false).getDirection();

        Direction expected = new Direction(true, false);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void 사다리_연결_가능_검증() {
        Direction result = createPoint(false, false).next(true).getDirection();

        Direction expected = new Direction(false, true);

        assertThat(result).isEqualTo(expected);
    }

    private Point createPoint(boolean left, boolean right) {
        return new Point(1, new Direction(left, right));
    }

}