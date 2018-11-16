package domain.ladder;

import org.junit.Test;
import view.console.ResultView;

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

        List<String> result = Arrays.asList("꽝","5000","꽝","3000");
        LadderResult ladderResult = new LadderResult(result);
        assertThat(laddering.showResult("pobi", ladderResult).get(0)).isEqualTo(new PlayResult(new Player("pobi"), "꽝"));

    }
}
