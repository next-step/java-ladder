package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.strategy.FakeGenerator;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private static final int INPUT_NUM_OF_USERS = 4;
    private static final int INPUT_NUM_OF_HEIGHT = 4;

    @Test
    public void create() {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0 ; i < INPUT_NUM_OF_HEIGHT ; i++) {
            lines.add(Line.create(INPUT_NUM_OF_USERS, new FakeGenerator()));
        }

        Ladder ladder = new Ladder(lines);
        assertThat(ladder.move(0)).isEqualTo(0);
    }

    @Test
    public void of() {
        Ladder ladder = Ladder.of(INPUT_NUM_OF_HEIGHT, INPUT_NUM_OF_USERS, new FakeGenerator());
        assertThat(ladder.move(0)).isEqualTo(0);
    }
}
