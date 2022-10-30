package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("오른쪽으로 이동")
    void move_right() {
        //given
        Point point = new Point(0, Direction.of(false, true));
        //when
        assertThat(point.move()).isOne();
    }

    @Test
    @DisplayName("왼쪽으로 이동")
    void move_left() {
        //given
        Point point = new Point(1, Direction.of(true, false));
        //when
        assertThat(point.move()).isZero();
    }

    @Test
    @DisplayName("이동 안암")
    void move_none() {
        //given
        Point point = new Point(0, Direction.of(false, false));
        //when
        assertThat(point.move()).isZero();
    }

}