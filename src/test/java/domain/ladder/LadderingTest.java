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

        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        Lines lines = new Lines(line);

        List<Line> line2 = new ArrayList<>();
        line2.add(new Line(Arrays.asList(false, true, false)));
        Lines lines2 = new Lines(line2);

        List<Line> line3 = new ArrayList<>();
        line3.add(new Line(Arrays.asList(true, false, false)));
        Lines lines3 = new Lines(line3);

        List<Line> line4 = new ArrayList<>();
        line4.add(new Line(Arrays.asList(false, true, false)));
        Lines lines4 = new Lines(line4);

        List<Line> line5 = new ArrayList<>();
        line5.add(new Line(Arrays.asList(true, false, true)));
        Lines lines5 = new Lines(line5);

        List<Lines> lineList = new ArrayList<>();
        lineList.add(lines);
        lineList.add(lines2);
        lineList.add(lines3);
        lineList.add(lines4);
        lineList.add(lines5);

        Laddering laddering = new Laddering(players, lineList);

        List<String> result = Arrays.asList("꽝","5000","꽝","3000");
        LadderResult ladderResult = new LadderResult(result);
        assertThat("" + laddering.showResult("pobi", ladderResult).get(0)+"").isEqualTo("pobi : 꽝");
        assertThat("" + laddering.showResult("honux", ladderResult).get(0)+"").isEqualTo("honux : 3000");
        assertThat("" + laddering.showResult("crong", ladderResult).get(0)+"").isEqualTo("crong : 꽝");
        assertThat("" + laddering.showResult("jk", ladderResult).get(0)+"").isEqualTo("jk : 5000");

    }

}
