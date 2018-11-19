package domain.ladder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderingTest {

    Laddering laddering;
    LadderResult ladderResult;
    LadderManage ladderManage;

    @Before
    public void init() {
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

        laddering = new Laddering(players, lines);

        List<String> result = Arrays.asList("꽝","5000","꽝","3000");
        ladderResult = new LadderResult(result);

        ladderManage = new LadderManage(player, line);

    }

    @Test
    public void 사다리결과() {
        ladderManage.play("pobi");
        assertThat("" + laddering.playerResult(ladderResult).get(0)+"").isEqualTo("pobi : 꽝");
    }

    @Test
    public void 사다리결과_ALL() {
        ladderManage.play("ALL");
        assertThat("" + laddering.playerResult(ladderResult).get(0)+"").isEqualTo("pobi : 꽝");
        assertThat("" + laddering.playerResult(ladderResult).get(1)+"").isEqualTo("honux : 3000");
        assertThat("" + laddering.playerResult(ladderResult).get(2)+"").isEqualTo("crong : 꽝");
        assertThat("" + laddering.playerResult(ladderResult).get(3)+"").isEqualTo("jk : 5000");
    }

}
