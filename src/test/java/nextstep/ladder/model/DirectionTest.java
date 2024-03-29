package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    void 왼쪽이동시_1감소한_값을_반환한다() {
        int current = 1;

        Direction left = Direction.LEFT;
        int next = left.next(current);

        assertThat(next).isEqualTo(0);
    }

    @Test
    void 오른쪽이동시_1증가한_값을_반환한다() {
        int current = 1;

        Direction left = Direction.RIGHT;
        int next = left.next(current);

        assertThat(next).isEqualTo(2);
    }

    @Test
    void 아래이동시_동일한_값을_반환한다() {
        int current = 1;

        Direction left = Direction.DOWN;
        int next = left.next(current);

        assertThat(next).isEqualTo(1);
    }
}
