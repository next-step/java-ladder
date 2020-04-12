package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    /**
     * startPosition: 0
     * |-----|
     */
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    /**
     * startPosition: 1
     * |     |     |
     */
    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    /**
     * startPosition: 1
     * |-----|     |
     */
    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    /**
     * startPosition: 1
     * |     |-----|
     */
    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    /**
     * startPosition: 1
     * |-----|     |
     */
    @Test
    @DisplayName("첫번째 Point가 Right true이면, 다음 Point는 무조건 Right false 여야 한다.(가로라인이 겹치는 경우 어느 방향으로 이동할 지 결정할 수 없다.)")
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
