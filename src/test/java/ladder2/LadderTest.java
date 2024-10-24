package ladder2;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리_전체_결과를_반환한다() {
        Position first1 = Position.first(true);
        Position next1 = first1.next(false);
        Position last1 = next1.last();

        Position first2 = Position.first(false);
        Position next2 = first2.next(true);
        Position last2 = next2.last();

        Line line1 = new Line(List.of(first1, next1, last1));
        Line line2 = new Line(List.of(first2, next2, last2));

        Ladder ladder = new Ladder(List.of(line1, line2));

        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(1);
    }
}
