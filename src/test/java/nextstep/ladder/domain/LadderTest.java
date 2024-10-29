package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 사다리_생성() {
        List<Point> points = List.of(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false));
        Line line = new Line(points);
        Ladder ladder = new Ladder(List.of(line));
        assertThat(ladder).isEqualTo(new Ladder(List.of(line)));
    }
}
