package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static final int NUMBER_OF_PEOPLE = 5;
    private static List<Point> points;

    @Test
    void test_Equal_subtract_one_from_number_If_create_line_with_Same_number_of_people() {
        Line line = new Line(NUMBER_OF_PEOPLE, RandomLineStrategy.getInstance());
        assertThat(line.getPoints().size()).isEqualTo(NUMBER_OF_PEOPLE);
    }

    @Test
    void test_Equal_listOf_TrueFalseTrueFalse_If_create_line_with_Number_of_people() {
        points = Arrays.asList(
                Point.init(true),
                Point.init(false),
                Point.init(true),
                Point.init(false),
                Point.init(false)
        );

        Line line = new Line(NUMBER_OF_PEOPLE, () -> true);
        List<Point> points = line.getPoints();
        assertThat(points).isEqualTo(points);
    }

}
