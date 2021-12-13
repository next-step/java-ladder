package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {

    @DisplayName("If there is a line, first point moves right. Otherwise, it moves left.")
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isZero();
    }

    @DisplayName("If there is no line between first and second points, second point moves to the same position.")
    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("If there is a line between first and second points, second point moves left.")
    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isZero();
    }

    @DisplayName("If there is a line right from second point, second point moves right.")
    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("If there is a line left from second point, second point move left.")
    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isZero();
    }
}
