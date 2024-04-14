package ladder.domain.ladder;

import ladder.domain.ladders.ladder.Ladder;
import ladder.domain.ladders.ladder.Line;
import ladder.domain.participants.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    public static final Ladder ladder = new Ladder(List.of(
            new Line(false, true),
            new Line(true, false),
            new Line(false, true)
    ));

    @Test
    void move_on_ladder() {
        Position moved = ladder.move(new Position(0));

        assertThat(moved).isEqualTo(new Position(2));
    }
}