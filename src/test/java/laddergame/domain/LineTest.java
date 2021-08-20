package laddergame.domain;

import laddergame.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void create() {
        // given
        int countOfPeople = 5;

        // when
        Line line = new Line(countOfPeople,new RandomLineStrategy());

        // then
        assertThat(line.size()).isEqualTo(countOfPeople-1);
        assertThat(line.getPoints().get(0)).isInstanceOf(Boolean.class);
    }

    @Test
    void check_true_and_false() {
        // given
        int countOfPeople = 4;

        // when
        Line line = new Line(countOfPeople, () -> true);

        // then
        assertThat(line.getPoints()).containsExactly(true, false, true);
    }
}