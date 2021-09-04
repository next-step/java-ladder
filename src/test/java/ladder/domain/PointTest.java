package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("Point Direction 테스트")
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    @DisplayName("처음 값이 있고 다음 포인트에서 움직임 테스트")
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("두번째 값이 있고 왼쪽이 있으면 왼쪽으로 움직임 테스트")
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("처음 값이 있고 오른쪽이 있으면 오른쪽으로 움직임 테스트")
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }
}