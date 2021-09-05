package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void create() {
        assertAll(
                () -> assertThat(Point.init(true).move()).isEqualTo(1),
                () -> assertThat(Point.init(false).move()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("사다리에 가로 라인이 겹치지는 지 검증 (true, true)시 예외 발생 ")
    void inValid() {
        Point initPoint = Point.init(true);
        assertThatThrownBy(() -> initPoint.next(true));
    }



    @Test
    @DisplayName("사다리가 이동 방향 오른쪽 테스트")
    void right() {
        Direction right = Direction.init(true);
        assertThat(new Point(0, right).move()).isEqualTo(1);//(false, true) ,(true, false)
    }

    @Test
    @DisplayName("사다리 이동 방향 왼쪽 테스트")
    void left() {
        Direction left = Direction.init(true).next(false);
        assertThat(new Point(2,left).move()).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 가로 라인이 없는 아래쪽 테스트")
    void pass() {
        Direction pass = Direction.init(false).next(false);
        assertThat(new Point(1,pass).move()).isEqualTo(1);
    }
}