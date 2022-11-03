package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static final int NUMBER_OF_PEOPLE = 5;

    @Test
    void test_Equal_subtract_one_from_number_If_create_line_with_Same_number_of_people() {
        Line line = new Line(NUMBER_OF_PEOPLE, RandomLineStrategy.getInstance());
        assertThat(line.getPoints().size()).isEqualTo(NUMBER_OF_PEOPLE - 1);
    }

    @Test
    void test_Equal_listOf_TrueFalseTrueFalse_If_create_line_with_Number_of_people() {
        Line line = new Line(NUMBER_OF_PEOPLE, () -> true);
        List<Boolean> points = line.getPoints();
        assertThat(points).isEqualTo(List.of(true, false, true, false));
    }
}
