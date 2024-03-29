package nextstep.step4.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    void 왼쪽이동시_1감소한_값을_반환한다() {
        int current = 1;

        Direction left = Direction.LEFT;
        int next = left.move(current);

        assertThat(next).isEqualTo(0);
    }

    @Test
    void 오른쪽이동시_1증가한_값을_반환한다() {
        int current = 1;

        Direction right = Direction.RIGHT;
        int next = right.move(current);

        assertThat(next).isEqualTo(2);
    }

    @Test
    void 아래이동시_동일한_값을_반환한다() {
        int current = 1;

        Direction down = Direction.DOWN;
        int next = down.move(current);

        assertThat(next).isEqualTo(1);
    }
}
