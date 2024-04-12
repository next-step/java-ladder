package ladder.domain.ladder;

import ladder.domain.participants.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void move_on_ladder() {
        Ladder ladder = new Ladder(List.of(
                new Line(false, true, false),
                new Line(true,false, true),
                new Line(false, true, false)
        ));
        Position moved = ladder.move(new Position(0));

        assertThat(moved).isEqualTo(new Position(2));
    }
}