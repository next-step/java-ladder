import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PointTest {
    @Test
    public void move_right() {
        Point point = new Point(0, Direction.RIGHT);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    public void move_left() {
        Point point = new Point(1, Direction.LEFT);
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    public void move_straight() {
        Point point = new Point(3, Direction.STRAIGHT);
        assertThat(point.move()).isEqualTo(3);
    }
}