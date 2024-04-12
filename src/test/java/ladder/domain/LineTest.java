package ladder.domain;

import ladder.domain.ladder.Line;
import ladder.domain.participants.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @Test
    void not_overlap_lines_of_ladder() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(true, true, false));
    }

    @Test
    void get_line() {
        Line line = new Line(false, false, true);
        assertThat(line.getLine()).isEqualTo(List.of(false, false, true));
    }

    @Test
    void inquire_can_move_at_a_specific_position_on_the_line() {
        Line line = new Line(false, false, true);
        final Position position = new Position(0);
        assertThat(line.move(position)).isEqualTo(new Position(0));
    }
}
