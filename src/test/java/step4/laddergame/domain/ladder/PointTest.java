package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    private static final int INIT_INDEX = 0;
    private int index = 2;
    private Direction non = Direction.of(FALSE, FALSE);

    @Test
    void 위치와방향정보을가지는점을생성() {
        Point point = new Point(index, non);
        assertThat(point).isEqualTo(new Point(index, non));
    }

    @Test
    @DisplayName("오른쪽 방향이 참일경우 위치를 오른쪽으로 한 칸 움직인다.")
    void 오른쪽으로이동(){
        Direction right = Direction.of(FALSE, TRUE);
        assertThat(new Point(index, right).move()).isEqualTo(index + 1);
    }

    @Test
    @DisplayName("왼쪽 방향이 참일경우 위치를 왼쪽으로 한 칸 움직인다.")
    void 왼쪽으로이동(){
        Direction left = Direction.of(TRUE, FALSE);
        assertThat(new Point(index, left).move()).isEqualTo(index - 1);
    }

    @Test
    @DisplayName("참인 방향이 없을경우 위치 그대로를 반환한다.")
    void 제자리() {
        assertThat(new Point(index, non).move()).isEqualTo(index);
    }

    @Test
    void 처음점을이동() {
        assertThat(Point.first(TRUE).move()).isEqualTo(INIT_INDEX + 1);
        assertThat(Point.first(FALSE).move()).isEqualTo(INIT_INDEX);
    }

    @Test
    void 오른쪽으로연결된다음점을이동() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(INIT_INDEX + 2);
    }

    @Test
    void 왼쪽으로연결된다음점을이동() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(INIT_INDEX);
    }

    @Test
    void 연결되지않은다음점을이동() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(INIT_INDEX + 1);
    }

    @Test
    @DisplayName("새로 생성되는 점의 오른쪽 방향의 생성 전략이므로, 오른쪽으로 움직이거나 멈추거나 둘중하나이다.")
    void 전략에따라_연결된다음점을이동() {
        Point first = Point.first(FALSE);
        assertThat(first.next(() -> true).move()).isEqualTo(INIT_INDEX + 2);
        assertThat(first.next(() -> false).move()).isEqualTo(INIT_INDEX + 1);
    }
}
