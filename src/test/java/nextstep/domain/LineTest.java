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
    void 인원수에_따라_Line_객체_생성시_해당_인원수만큼_direction_을_반환한다() {
        Line line = new Line(NUMBER_OF_PEOPLE, RandomLineStrategy.getInstance());
        assertThat(line.getDirections().size()).isEqualTo(NUMBER_OF_PEOPLE);
    }

    @Test
    void true_로_시작하는_Line_객체_생성시_TrueFalseTrueFalse_형태로_directions_를_반환한다() {
        directions = Arrays.asList(
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
