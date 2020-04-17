package ladder.ladder.domain;

import ladder.ladder.infrastructure.RandomLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("포인트를 초기화 할 수 있다")
    @Test
    void init() {
        Direction direction = Direction.of(FALSE, TRUE);
        assertThat(Point.of(0, direction)).isEqualTo(Point.of(0, direction));
    }

    @DisplayName("첫번째 포인트는 방향에 인덱스가 변한다")
    @Test
    public void moveFirstPoint() {
        assertThat(Point.generateFirst(TRUE).move()).isEqualTo(Index.of(1));
        assertThat(Point.generateFirst(FALSE).move()).isEqualTo(Index.of(0));
    }

    @DisplayName("왼쪽 연결도 없고 오른쪽 연결도 없는 포인트는 움직이면 인덱스가 변경되지 않는다")
    @Test
    public void stayNext() {
        Point first = Point.generateFirst(FALSE);
        Point second = first.generateNext(FALSE);

        assertThat(second.move()).isEqualTo(Index.of(1));
    }

    @DisplayName("왼쪽은 연결되어 있고 오른쪽 연결이 없는 포인트는 움직이면 인덱스가 감소한다")
    @Test
    public void moveLeft() {
        Point first = Point.generateFirst(TRUE);
        Point second = first.generateNext(FALSE);

        assertThat(second.move()).isEqualTo(Index.of(0));
    }

    @DisplayName("왼쪽 연결은 없고 오른쪽 연결되어 있는 포인트는 움직이면 인덱스가 증가한다")
    @Test
    public void moveRight() {
        Point first = Point.generateFirst(FALSE);
        Point second = first.generateNext(TRUE);

        assertThat(second.move()).isEqualTo(Index.of(2));
    }

    @DisplayName("추후_삭제")
    @Test
    public void 추후_삭제() {
        Point second = Point.generateFirst(TRUE).generateNext(true);
        Point third = second.generateLast();

        assertThat(second.move()).isEqualTo(Index.of(0));
        assertThat(third.move()).isEqualTo(Index.of(2));
    }

}
