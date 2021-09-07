package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("포인트 좌측 이동 테스트")
    @Test
    public void moveLeft() {
        //given
        Point point = new Point(1, Direction.left());

        //when
        int actual = point.move();
        //then
        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("포인트 좌측 이동 테스트")
    @Test
    public void moveRight() {
        //given
        Point point = new Point(1, Direction.right());

        //when
        int actual = point.move();
        //then
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("포인트 좌측 이동 테스트")
    @Test
    public void moveStraight() {
        //given
        Point point = new Point(1, Direction.straight());

        //when
        int actual = point.move();
        //then
        assertThat(actual).isEqualTo(1);
    }
}
