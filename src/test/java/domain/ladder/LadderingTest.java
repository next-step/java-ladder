package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderingTest {
    @Test
    public void 사다리결과() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("pobi"));
        players.add(new Player("honux"));
        players.add(new Player("crong"));
        players.add(new Player("jk"));

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(true, false, true)));
        lines.add(new Line(Arrays.asList(false, true, false)));
        lines.add(new Line(Arrays.asList(true, false, false)));
        lines.add(new Line(Arrays.asList(false, true, false)));
        lines.add(new Line(Arrays.asList(true, false, true)));

        Laddering laddering = new Laddering(players, lines);
        assertThat(laddering.showResult(new Player("pobi"))).isEqualTo(0);

    }
}
