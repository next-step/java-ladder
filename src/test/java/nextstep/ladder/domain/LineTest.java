package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static nextstep.ladder.domain.LineDirection.LEFT;
import static nextstep.ladder.domain.LineDirection.RIGHT;
import static nextstep.ladder.domain.LineDirection.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @Test
    @DisplayName("생성 / 라인이 겹치게 생성 / IllegalArgumentException")
    void createOverlapLineFail() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Line(Arrays.asList(RIGHT, RIGHT)));
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Line(Arrays.asList(STRAIGHT, LEFT, LEFT)));
    }

    @Test
    @DisplayName("이동 / / 성공")
    void move() {
        /*
        0     1     2     3     4     5
        |     |-----|     |     |-----|
         */
        Line line = new Line(Arrays.asList(STRAIGHT, RIGHT, LEFT, STRAIGHT, RIGHT, LEFT));

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(2);
        assertThat(line.move(2)).isEqualTo(1);
        assertThat(line.move(3)).isEqualTo(3);
        assertThat(line.move(4)).isEqualTo(5);
        assertThat(line.move(5)).isEqualTo(4);
    }

    @Test
    @DisplayName("이동 / 좌우 이동 / 성공")
    void moveLeftRight() {
        /*
        0     1
        |-----|
         */
        Line line = new Line(Arrays.asList(RIGHT, LEFT));

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 / 직진 이동 / 성공")
    void moveStraight() {
        /*
        0     1
        |     |
         */
        Line line = new Line(Arrays.asList(STRAIGHT, STRAIGHT));

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(1);
    }
}