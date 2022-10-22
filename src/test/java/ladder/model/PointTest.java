package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    public void 사다리_마지막_다리_검증() {
        Point point = new Point(1, new Direction(false, true));

        Direction expected = new Direction(true, false);

        Direction result = point.last().getDirection();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void 사다리_연결_불가능_검증() {
        Point point = new Point(1, new Direction(false, true));

        Direction expected = new Direction(false, false);

        Direction result = point.next(false).getDirection();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void 사다리_연결_가능_검증() {
        Point point = new Point(1, new Direction(false, false));

        Direction expected = new Direction(false, true);

        Direction result = point.next(true).getDirection();

        assertThat(result).isEqualTo(expected);
    }

}