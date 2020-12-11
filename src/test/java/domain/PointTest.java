package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("첫번째 Point객체의 움직임 테스트")
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    @DisplayName("첫번째 Point객체의 움직임 테스트")
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("첫번째 Point객체의 움직임 테스트")
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("첫번째 Point객체의 움직임 테스트")
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("첫번째 Point객체의 움직임 테스트")
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
