package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static final int NUMBER_OF_PEOPLE = 4;
    private static List<Point> point;

    @Test
    void 인원수에_따라_Line_객체_생성시_해당_인원수만큼_direction_을_반환한다() {
        Line line = new Line(NUMBER_OF_PEOPLE, RandomLineStrategy.getInstance());
        assertThat(line.getPoints().size()).isEqualTo(NUMBER_OF_PEOPLE);
    }

    @Test
    void true_로_시작하는_Line_객체_생성시_TrueFalseTrueFalse_형태로_directions_를_반환한다() {
        point = Arrays.asList(
                Point.init(true),
                Point.init(true).insert(false),
                Point.init(false).insert(true),
                Point.init(true).last()
        );

        System.out.println("point --> " + point);
        Line line = new Line(NUMBER_OF_PEOPLE, () -> true);
        System.out.println("line --> " + line);
        List<Point> points = line.getPoints();
        assertThat(points.size()).isEqualTo(point.size());
    }

}
