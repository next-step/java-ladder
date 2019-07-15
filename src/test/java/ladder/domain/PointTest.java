package ladder.domain;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class PointTest {
    @Test
    @DisplayName("초기값 설정 체크")
    public void first() {
        assertThat(Point.first(TRUE).move(), is(1));
        assertThat(Point.first(FALSE).move(), is(0));
    }

    @Test
    @DisplayName("직진 기능 체크 ")
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move(), is(1));
    }

    @Test
    @DisplayName("왼쪽 이동 체크 ")
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move(), is(0));
    }

    @Test
    @DisplayName("오른쪽 이동 체크 ")
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move(), is(2));
    }

    @Test
    @DisplayName("인근 포인트 중복값 체크 ")
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move(), is(0));
    }

}