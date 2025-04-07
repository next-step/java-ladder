package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.JunctionTest.createJunction1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalStateException;

class DirectionsTest {

    @Test
    void 좌_우_아래순으로_탐색한다1() {
        Junction curr = createJunction1();
        Junction left = createJunction1();
        Junction down = createJunction1();

        left.connectRight(curr);
        curr.connectDown(down);

        Junction actual = Directions.move(curr, new ParticipantName("1"));
        assertThat(actual).isEqualTo(left);
    }

    @Test
    void 좌_우_아래순으로_탐색한다2() {
        Junction curr = createJunction1();
        Junction right = createJunction1();
        Junction down = createJunction1();

        curr.connectRight(right);
        curr.connectDown(down);

        Junction actual = Directions.move(curr, new ParticipantName("1"));
        assertThat(actual).isEqualTo(right);
    }

    @Test
    void 좌_우가_없어야_아래로_이동한다() {
        Junction curr = createJunction1();
        Junction down = createJunction1();

        curr.connectDown(down);

        Junction actual = Directions.move(curr, new ParticipantName("1"));
        assertThat(actual).isEqualTo(down);
    }

    @Test
    void 이동할_곳이_없다면_오류가_발생한다() {
        Junction curr = createJunction1();

        IllegalStateException e
                = catchIllegalStateException(() -> Directions.move(curr, new ParticipantName("1")));

        assertThat(e).hasMessage("이동할 수 없습니다.");
    }

}
