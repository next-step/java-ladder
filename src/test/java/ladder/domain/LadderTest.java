package ladder.domain;

import ladder.controller.Ladder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void move() {
        Lines lines = new Lines(Arrays.asList(
                new Line(Arrays.asList(true, false, true)),
                new Line(Arrays.asList(false, true, false))
        ));
        Ladder ladder = new Ladder(lines, 0);
        ladder.down();
        assertThat(ladder.coordinate()).isEqualTo(new Coordinate(0,1));
    }

    @Test
    void trueGoesRightNDownFalseGoesDown() {
        Lines lines = new Lines(Arrays.asList(
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, false)),
                new Line(Arrays.asList(true, false, false))
        ));
        Ladder ladder = new Ladder(lines, 0);
        ladder.play();
        assertThat(ladder.coordinate()).isEqualTo(new Coordinate(0,1)); // down
        ladder.play();
        assertThat(ladder.coordinate()).isEqualTo(new Coordinate(1,2)); // right, down
        ladder.play();
        assertThat(ladder.coordinate()).isEqualTo(new Coordinate(0,3)); // left, down
    }

    @Test
    void plays() {
        Lines lines = new Lines(Arrays.asList(
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, false)),
                new Line(Arrays.asList(true, false, false))
        ));
        Ladder ladder = new Ladder(lines, 0);
        ladder.plays();
        assertThat(ladder.coordinate()).isEqualTo(new Coordinate(0,3)); // left, dow.
    }

    @Test
    void playsFromFourth() {
        Lines lines = new Lines(Arrays.asList(
                new Line(Arrays.asList(false, true, false, false)),
                new Line(Arrays.asList(true, false, true, false)),
                new Line(Arrays.asList(true, false, false, false))
        ));
        Ladder ladder = new Ladder(lines, 3);
        ladder.plays();
        assertThat(ladder.coordinate()).isEqualTo(new Coordinate(2,3));
    }
}
