package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.People;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void generateLadder() {
        Ladder ladder = new Ladder(3);

        List<Line> lines = ladder.generateLadder();
        assertThat(lines.size()).isEqualTo(3);
    }
}