package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<Point> points = List.of(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false));
        Line line = new Line(points);
        ladder = new Ladder(List.of(line));
    }

    @Test
    void 사다리_생성() {
        List<Point> points = List.of(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false));
        Line line = new Line(points);
        assertThat(ladder).isEqualTo(new Ladder(List.of(line)));
    }

    @Test
    void 사다리_실행결과_반환() {
        assertThat(ladder.move(0)).isEqualTo(1);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(2);
    }
}
