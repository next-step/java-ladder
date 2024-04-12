package ladder.domain.participants;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.result.Reward;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GamerTest {

    @Test
    void climb_a_ladder() {
        String name = "user";
        int initPosition = 0;
        int lastPosition = 2;
        Gamer gamer = new Gamer(name, initPosition);
        Ladder ladder = new Ladder(List.of(
                new Line(true, false, true),
                new Line(false, true, false)
        ));

        assertThat(gamer.climb(ladder))
                .isEqualTo(new Gamer(name, lastPosition));
    }

    @Test
    void check_has_same_name() {
        String name = "user";
        int initPosition = 0;
        Gamer gamer = new Gamer(name, initPosition);
        assertThat(gamer.hasSameName(new Name(name))).isTrue();
    }

    @Test
    void check_has_same_position() {
        String name = "user";
        int initPosition = 0;
        Gamer gamer = new Gamer(name, initPosition);
        Reward item = new Reward("item", initPosition);
        assertThat(gamer.hasSamePosition(item)).isTrue();
    }
}