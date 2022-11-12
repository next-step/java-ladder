package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static final int NUMBER_OF_PEOPLE = 5;
    private static List<Direction> directions;

    @Test
    void test_Equal_subtract_one_from_number_If_create_line_with_Same_number_of_people() {
        Line line = new Line(NUMBER_OF_PEOPLE, RandomLineStrategy.getInstance());
        assertThat(line.getDirections().size()).isEqualTo(NUMBER_OF_PEOPLE);
    }

    @Test
    void test_Equal_listOf_TrueFalseTrueFalse_If_create_line_with_Number_of_people() {
        LineTest.directions = Arrays.asList(
                Direction.init(true),
                Direction.init(false),
                Direction.init(true),
                Direction.init(false),
                Direction.init(false)
        );

        Line line = new Line(NUMBER_OF_PEOPLE, () -> true);
        List<Direction> directions = line.getDirections();
        assertThat(directions).isEqualTo(directions);
    }

}
