package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    /**
     * |-----|     |
     * |     |-----|
     * |     |-----|
     * |-----|     |
     * */
    @Test
    void pointsMoveTest() {
        List<Line> totalLine = new ArrayList<>();

        totalLine.add(createSingleLeftLinePoint());
        totalLine.add(createSingleRightLinePoint());
        totalLine.add(createSingleRightLinePoint());
        totalLine.add(createSingleLeftLinePoint());

        Lines lines = new Lines(totalLine);

        assertThat(lines.move(0)).isEqualTo(0);
        assertThat(lines.move(1)).isEqualTo(1);
        assertThat(lines.move(2)).isEqualTo(2);
    }

    /**
     * |-----|     |
     * |-----|     |
     * |     |-----|
     * |-----|     |
     * */
    @Test
    void pointsMoveTest2() {
        List<Line> totalLine = new ArrayList<>();

        totalLine.add(createSingleLeftLinePoint());
        totalLine.add(createSingleLeftLinePoint());
        totalLine.add(createSingleRightLinePoint());
        totalLine.add(createSingleLeftLinePoint());

        Lines lines = new Lines(totalLine);

        assertThat(lines.move(0)).isEqualTo(1);
        assertThat(lines.move(1)).isEqualTo(2);
        assertThat(lines.move(2)).isEqualTo(0);
    }

    /**
     * |-----|     |
     * */
    private static Line createSingleLeftLinePoint() {
        List<Point> totalPoint = new ArrayList<>();

        Point firstPoint = new Point(0, true, null);
        Point secondPoint = new Point(1, false, firstPoint);
        Point thirdPoint = secondPoint.createLast();

        totalPoint.add(firstPoint);
        totalPoint.add(secondPoint);
        totalPoint.add(thirdPoint);

        return new Line(new Points(totalPoint));
    }

    /**
     * |     |-----|
     * */
    private static Line createSingleRightLinePoint() {
        List<Point> totalPoint = new ArrayList<>();

        Point firstPoint = new Point(0, false, null);
        Point secondPoint = new Point(1, true, firstPoint);
        Point thirdPoint = secondPoint.createLast();

        totalPoint.add(firstPoint);
        totalPoint.add(secondPoint);
        totalPoint.add(thirdPoint);

        return new Line(new Points(totalPoint));
    }
}
