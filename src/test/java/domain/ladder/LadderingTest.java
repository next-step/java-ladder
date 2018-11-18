package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderingTest {
    @Test
    public void 사다리결과() {
        List<Player> player = new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("honux"));
        player.add(new Player("crong"));
        player.add(new Player("jk"));
        Players players = new Players(player);

        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        line.add(new Line(Arrays.asList(false, true, false)));
        line.add(new Line(Arrays.asList(true, false, false)));
        line.add(new Line(Arrays.asList(false, true, false)));
        line.add(new Line(Arrays.asList(true, false, true)));

        Lines lines = new Lines(line);

        Laddering laddering = new Laddering(players, lines);

        List<String> result = Arrays.asList("꽝","5000","꽝","3000");
        LadderResult ladderResult = new LadderResult(result);
        assertThat("" + laddering.showResult("pobi", ladderResult).get(0)+"").isEqualTo("pobi : 꽝");
        assertThat("" + laddering.showResult("honux", ladderResult).get(0)+"").isEqualTo("honux : 3000");
        assertThat("" + laddering.showResult("crong", ladderResult).get(0)+"").isEqualTo("crong : 꽝");
        assertThat("" + laddering.showResult("jk", ladderResult).get(0)+"").isEqualTo("jk : 5000");

    }

    @Test
    public void 사다리결과_ALL() {
        List<Player> player = new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("honux"));
        player.add(new Player("crong"));
        player.add(new Player("jk"));
        Players players = new Players(player);

        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        line.add(new Line(Arrays.asList(false, true, false)));
        line.add(new Line(Arrays.asList(true, false, false)));
        line.add(new Line(Arrays.asList(false, true, false)));
        line.add(new Line(Arrays.asList(true, false, true)));

        Lines lines = new Lines(line);

        Laddering laddering = new Laddering(players, lines);

        List<String> result = Arrays.asList("꽝","5000","꽝","3000");
        LadderResult ladderResult = new LadderResult(result);
        assertThat("" + laddering.showResult("ALL", ladderResult).get(0)+"").isEqualTo("pobi : 꽝");
        assertThat("" + laddering.showResult("ALL", ladderResult).get(1)+"").isEqualTo("honux : 3000");
        assertThat("" + laddering.showResult("ALL", ladderResult).get(2)+"").isEqualTo("crong : 꽝");
        assertThat("" + laddering.showResult("ALL", ladderResult).get(3)+"").isEqualTo("jk : 5000");

    }

}
