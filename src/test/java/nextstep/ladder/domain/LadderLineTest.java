package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderLineTest {
    @Test
    public void init() {
        LadderLine ladderLine = LadderLine.of(2, ()-> true);
        assertThat(ladderLine.move(0)).isEqualTo(1);
    }

    @Test
    public void move() {
        List<Point> points = Arrays.asList(
                new Point(0, Direction.of(false, true)),
                new Point(1, Direction.of(true, false)),
                new Point(2, Direction.of(false, false))
        );
        assertThat(LadderLine.of(3, ()-> true).getPoints()).isEqualTo(points);
    }
}
