package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("첫번째 포인트를 생성한다")
    @Test
    public void firstInitTest() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @DisplayName("다음칸으로 이동하지 않는 포인트를 생성한다")
    @Test
    public void nextStayTest() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("왼쪽으로 이동하는 포인트를 생성한다")
    @Test
    public void nextLeftTest() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @DisplayName("오른쪽으로 이동하는 포인트를 생성한다")
    @Test
    public void nextRightTest() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("왼쪽이 연결되어있다면, 왼쪽으로 연결된다")
    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
