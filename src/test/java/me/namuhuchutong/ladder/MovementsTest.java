package me.namuhuchutong.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static me.namuhuchutong.ladder.domain.wrapper.Movements.*;
import static org.assertj.core.api.Assertions.*;


class MovementsTest {

    @DisplayName("사디리 왼쪽을 이동할 땐 -2칸 움직인다.")
    @Test
    void move_left_2() {
        int currentPoint = 3;
        int expected = 1;

        int actual = MOVE_LEFT.move(currentPoint);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사다리 오른쪽을 이동할 땐 +2칸 움직인다.")
    @Test
    void move_right_2() {
        int currentPoint = 3;
        int expected = 5;

        int actual = MOVE_RIGHT.move(currentPoint);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사다리가 움직일 수 없다면 정지한다.")
    @Test
    void stop() {
        int currentPoint = 3;
        int expected = 3;

        int actual = STOP.move(currentPoint);

        assertThat(actual).isEqualTo(expected);
    }
}
