package step4.domain;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LadderTest {
    @Test
    void init() {
        // given
        int height = 5;
        int countOfPerson = 5;
        Ladder ladder = Ladder.of(countOfPerson, height);
        // when & then
        assertThat(ladder.ladderHeight()).isEqualTo(height);
    }

    @Test
    void validate() {
        // given
        int height = 0;
        int countOfPerson = 5;
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Ladder.of(countOfPerson, height));
    }

    @Test
    void play() {
        // given
        LadderLine first = new LadderLine(
            Arrays.asList(left(0), middle(1), right(2)));
        LadderLine second = new LadderLine(
            Arrays.asList(left(0), middle(1), right(2)));
        LadderLine third = new LadderLine(
            Arrays.asList(left(0), middle(1), right(2)));
        // when
        Ladder ladder = Ladder.of(Arrays.asList(first, second, third));
        // then
        assertThat(ladder.play(0)).isEqualTo(1);
        assertThat(ladder.play(1)).isEqualTo(0);
        assertThat(ladder.play(2)).isEqualTo(2);
    }

    private Point left(int position) {
        return new Point(position, Direction.of(FALSE, TRUE));
    }

    private Point middle(int position) {
        return new Point(position, Direction.of(TRUE, FALSE));
    }

    private Point right(int position) {
        return new Point(position, Direction.of(FALSE, FALSE));
    }
}
