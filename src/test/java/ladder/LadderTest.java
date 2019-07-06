package ladder;

import ladder.domain.*;
import ladder.domain.strategy.FakeGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private static final int INPUT_NUM_OF_USERS = 4;
    private static final int INPUT_NUM_OF_HEIGHT = 4;

    private Ladder ladder;

    @Before
    public void setUp() {
        ladder = Ladder.of(INPUT_NUM_OF_HEIGHT, INPUT_NUM_OF_USERS, new FakeGenerator());
    }

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
        assertThat(ladder.move(0)).isEqualTo(0);
    }

    @Test
    public void result() {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        assertThat(ladder.getResult()).isEqualTo(new LadderResult(map));
    }
}
