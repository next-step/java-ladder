package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("Point.first 를 통해 왼쪽으로 갈 수 없는 Point 가 생성된다")
    void first() {
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
    }

    @Test
    @DisplayName("Next 를 통해 제자리에서 이동하는 Point 생성된다.")
    public void nextStay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("Next 를 통해 오른쪽으로 이동하는 Point 생성된다.")
    public void nextRight() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("Next 를 통해 왼쪽으로 이동하는 Point 생성된다.")
    public void nextLeft() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("인자없는 Next 를 통해 왼쪽으로 이동하는 Point 생성된다.")
    public void nextEmpty() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("last 를 통해 왼쪽으로 이동하는 Point 생성된다.")
    public void last() {
        Point last = Point.first(TRUE).last();
        assertThat(last.move()).isEqualTo(0);
    }
}
