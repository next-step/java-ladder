package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        int height = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(4, height);
        }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
    }

    @Test
    @DisplayName("사다리의 참여자 수(Point)는 2 이상이어야 한다.")
    void assertLadderWidth() {
        int participantCount = 1;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(participantCount, 5);
        }).withMessage(Line.POINT_COUNT_ERROR);
    }

    /**
     * |-----|     |
     * |     |-----|
     * |     |-----|
     */
    @Test
    void move() {
        List<Line> lines = new ArrayList<>();

        lines.add(createHasLineLeft());
        lines.add(createHasLineRight());
        lines.add(createHasLineRight());

        Ladder ladder = new Ladder(lines);

        assertThat(ladder.move(0)).isEqualTo(1);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(2);
    }

    /**
     * |     |-----|
     */
    private static Line createHasLineRight() {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(false);
        points.add(point);

        point = point.next(true);
        points.add(point);

        point = point.last();
        points.add(point);

        return new Line(points);
    }

    /**
     * |-----|     |
     */
    private static Line createHasLineLeft() {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(true);
        points.add(point);

        point = point.next();
        points.add(point);

        point = point.last();
        points.add(point);

        return new Line(points);
    }
}
