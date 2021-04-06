package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    /*
     *  create Ladder like
     *     |-----|     |-----|
     *     |     |-----|     |
     *     |-----|     |     |
     *     |     |-----|     |
     *     |-----|     |-----|
     */
    private static Ladder ladder() {
        return new Ladder(lines());
    }

    private static List<Line> lines() {
        List<Point> points1 = fourPoints();
        List<Point> points2 = fourPoints();
        List<Point> points3 = fourPoints();
        List<Point> points4 = fourPoints();
        List<Point> points5 = fourPoints();

        connectPoints(points1, 0, 1);
        connectPoints(points1, 2, 3);

        connectPoints(points2, 1, 2);

        connectPoints(points3, 0, 1);

        connectPoints(points4, 1, 2);

        connectPoints(points5, 0, 1);
        connectPoints(points5, 2, 3);

        return Stream.of(points1, points2, points3, points4, points5)
            .map(Line::new)
            .collect(Collectors.toList());
    }

    private static List<Point> fourPoints() {
        return Stream.generate(Point::new)
            .limit(4)
            .collect(Collectors.toList());
    }

    private static void connectPoints(List<Point> points, int leftPointPosition, int rightPointPosition) {
        points.get(leftPointPosition)
            .connectTo(points.get(rightPointPosition));
        points.get(rightPointPosition)
            .connectTo(points.get(leftPointPosition));
    }

    @Test
    @DisplayName("특정 위치에서 사다리를 쭉 따라 갔을 때 최종 위치를 반환한다.")
    void getResultPosition() {
        Ladder ladder = ladder();

        assertAll(
            () -> assertThat(ladder.passThrough(0)).isZero(),
            () -> assertThat(ladder.passThrough(1)).isEqualTo(3),
            () -> assertThat(ladder.passThrough(2)).isEqualTo(2),
            () -> assertThat(ladder.passThrough(3)).isEqualTo(1)
        );
    }

}
