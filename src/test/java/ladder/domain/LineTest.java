package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @Test
    public void Line_랜덤생성() {
        Line line = Line.of(4);
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @Test
    public void Line_수동생성_true() {
        Line line = Line.of(4);
        List<Boolean> points = line.getPoints().stream()
                .map(point -> point.isExist())
                .collect(Collectors.toList());
        assertThat(points).containsAll(Arrays.asList(true, true, true, true));
    }

    @Test
    public void Line_수동생성_false() {
        Line line = Line.of(4);
        List<Boolean> points = line.getPoints().stream()
                .map(point -> point.isExist())
                .collect(Collectors.toList());
        assertThat(points).containsAll(Arrays.asList(false, false, false, false));
    }

    @Test
    public void Line_이동() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(true));
        points.add(new Point(false));
        points.add(new Point(true));

        Line line = new Line(points);

        assertAll(
                () -> assertThat(line.canMoveRight(0)).isTrue(),
                () -> assertThat(line.canMoveLeft(0)).isFalse(),
                () -> assertThat(line.canMoveRight(1)).isFalse(),
                () -> assertThat(line.canMoveLeft(1)).isTrue(),
                () -> assertThat(line.canMoveRight(2)).isTrue(),
                () -> assertThat(line.canMoveLeft(2)).isFalse(),
                () -> assertThat(line.canMoveRight(3)).isFalse()
        );
    }
}