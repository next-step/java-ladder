package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void Ladder_생성() {
        Ladder ladder = Ladder.of(4, 5);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    public void 사다리_결과_인덱스() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(true));
        points.add(new Point(false));
        points.add(new Point(true));

        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(false));
        points2.add(new Point(true));
        points2.add(new Point(false));

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(points));
        lines.add(new Line(points2));
        lines.add(new Line(points));
        lines.add(new Line(points2));
        lines.add(new Line(points));

        Ladder ladder = new Ladder(lines);
        assertThat(ladder.getLadderEndIdx(0)).isEqualTo(2);
        assertThat(ladder.getLadderEndIdx(1)).isEqualTo(3);
        assertThat(ladder.getLadderEndIdx(2)).isEqualTo(0);
        assertThat(ladder.getLadderEndIdx(3)).isEqualTo(1);
    }
}