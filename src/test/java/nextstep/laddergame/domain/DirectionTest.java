package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    void findDirection() {
        Direction right = Direction.RIGHT;
        assertThat(right.moveLine(10)).isEqualTo(11);

        Direction left = Direction.LEFT;
        assertThat(left.moveLine(10)).isEqualTo(9);

        Direction notMove = Direction.NOT_MOVE;
        assertThat(notMove.moveLine(20)).isEqualTo(20);
    }
}