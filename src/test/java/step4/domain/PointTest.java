package step4.domain;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(Position.valueOf(1));
        assertThat(Point.first(FALSE).move()).isEqualTo(Position.valueOf(0));
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(Position.valueOf(1));
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(Position.valueOf(0));
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(Position.valueOf(2));
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isEqualTo(Position.valueOf(0));
    }
}
