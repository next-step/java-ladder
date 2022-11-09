package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("다음 Point가 오른쪽 연결")
    void test1() {
        Point point = Point.first(FALSE).next(() -> true);
        assertThat(point.isRightConnected()).isTrue();
    }

    @Test
    @DisplayName("이전 Point 오른쪽 연결 후 다음 Point의 오른쪽 연결 시도시 에러")
    void test2() {
        assertThatThrownBy(() -> {
            Point.first(TRUE).next(() -> true);
        }).isInstanceOf(IllegalStateException.class);
    }

}
