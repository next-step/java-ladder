package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 첫_포인트는_false() {
        Point first = Point.first();

        assertThat(first.isExists()).isFalse();
    }

    @Test
    public void 연속된_포인트는_둘_다_true_일_수_없다() {
        Point p1 = Point.first();
        Point p2 = Point.of(p1, true);
        Point p3 = Point.of(p2, true);
        Point p4 = Point.of(p3, true);

        assertThat(p2.isExists()).isTrue();
        assertThat(p3.isExists()).isFalse();
        assertThat(p4.isExists()).isTrue();
    }
}