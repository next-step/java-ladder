package nextstep.ladder.domain.player;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderLine;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static nextstep.ladder.domain.direction.Direction.DOWN;
import static nextstep.ladder.domain.direction.Direction.LEFT_DOWN;
import static nextstep.ladder.domain.direction.Direction.RIGHT_DOWN;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void create() {
        assertThat(new Player("test")).isEqualTo(new Player("test", 0));
    }
    
    @Test
    void play() {
        Player player = new Player("1", 0);
        Ladder ladder = new Ladder(List.of(
                getLadderLine(RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN, DOWN),
                getLadderLine(RIGHT_DOWN, LEFT_DOWN, DOWN, RIGHT_DOWN, LEFT_DOWN),
                getLadderLine(RIGHT_DOWN, LEFT_DOWN, RIGHT_DOWN, LEFT_DOWN, DOWN),
                getLadderLine(RIGHT_DOWN, LEFT_DOWN, DOWN, RIGHT_DOWN, LEFT_DOWN)));

        player.play(ladder);
        assertThat(player.getPosition()).isEqualTo(0);
    }
    
    private LadderLine getLadderLine(Direction... directions) {
        return new LadderLine(Arrays.asList(directions));
    }
}
