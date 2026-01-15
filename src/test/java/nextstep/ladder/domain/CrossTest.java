package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CrossTest {

    @Test
    void first_위치는_0() {
        Cross cross = Cross.first(true);
        assertThat(cross.move()).isEqualTo(1); // position(0) + RIGHT(1)
    }

    @Test
    void first_오른쪽연결시_오른쪽이동() {
        Cross cross = Cross.first(true);
        assertThat(cross.move()).isEqualTo(1);
        assertThat(cross.hasRightConnection()).isTrue();
    }

    @Test
    void first_연결없으면_제자리() {
        Cross cross = Cross.first(false);
        assertThat(cross.move()).isEqualTo(0);
        assertThat(cross.hasRightConnection()).isFalse();
    }

    @Test
    void next_이전오른쪽연결시_왼쪽이동() {
        // |-----|     |
        // 0     1     2
        Cross first = Cross.first(true);
        Cross second = first.next(false);
        assertThat(second.move()).isEqualTo(0); // position(1) + LEFT(-1)
    }

    @Test
    void next_오른쪽연결시_오른쪽이동() {
        // |     |-----|
        // 0     1     2
        Cross first = Cross.first(false);
        Cross second = first.next(true);
        assertThat(second.move()).isEqualTo(2); // position(1) + RIGHT(1)
    }

    @Test
    void next_연속된가로선_예외() {
        Cross first = Cross.first(true);
        assertThatThrownBy(() -> first.next(true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("연속된 가로선은 허용되지 않습니다.");
    }

    @Test
    void last_이전오른쪽연결시_왼쪽이동() {
        // |-----|
        // 0     1
        Cross first = Cross.first(true);
        Cross last = first.last();
        assertThat(last.move()).isEqualTo(0); // position(1) + LEFT(-1)
    }

    @Test
    void 사다리이동_시나리오() {
        // |-----|     |
        // 0     1     2
        Cross c0 = Cross.first(true);
        Cross c1 = c0.next(false);
        Cross c2 = c1.last();

        assertThat(c0.move()).isEqualTo(1); // 0 -> 1 (RIGHT)
        assertThat(c1.move()).isEqualTo(0); // 1 -> 0 (LEFT)
        assertThat(c2.move()).isEqualTo(2); // 2 -> 2 (DOWN)
    }
}