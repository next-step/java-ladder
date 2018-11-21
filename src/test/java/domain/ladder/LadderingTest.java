package domain.ladder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
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

/*        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        line.add(new Line(Arrays.asList(false, true, false)));
        line.add(new Line(Arrays.asList(true, false, false)));
        line.add(new Line(Arrays.asList(false, true, false)));
        line.add(new Line(Arrays.asList(true, false, true)));
        Lines lines = new Lines(line);*/


        List<Point> points1 = new ArrayList<>();
        points1.add(new Point(0, Direction.of(false,true)));
        points1.add(new Point(1, Direction.of(true,false)));
        points1.add(new Point(2, Direction.of(false,true)));
        points1.add(new Point(3, Direction.of(true,false)));
        LadderLine ladderLine = new LadderLine(points1);

        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(0, Direction.of(false,false)));
        points2.add(new Point(1, Direction.of(false,true)));
        points2.add(new Point(2, Direction.of(true,false)));
        points2.add(new Point(3, Direction.of(false,false)));
        LadderLine ladderLine2 = new LadderLine(points2);

        List<Point> points3 = new ArrayList<>();
        points3.add(new Point(0, Direction.of(false,true)));
        points3.add(new Point(1, Direction.of(true,false)));
        points3.add(new Point(2, Direction.of(false,false)));
        points3.add(new Point(3, Direction.of(false,false)));
        LadderLine ladderLine3 = new LadderLine(points3);

        List<Point> points4 = new ArrayList<>();
        points4.add(new Point(0, Direction.of(false,false)));
        points4.add(new Point(1, Direction.of(false,true)));
        points4.add(new Point(2, Direction.of(true,false)));
        points4.add(new Point(3, Direction.of(false,false)));
        LadderLine ladderLine4 = new LadderLine(points4);

        List<Point> points5 = new ArrayList<>();
        points5.add(new Point(0, Direction.of(false,true)));
        points5.add(new Point(1, Direction.of(true,false)));
        points5.add(new Point(2, Direction.of(false,true)));
        points5.add(new Point(3, Direction.of(true,false)));
        LadderLine ladderLine5 = new LadderLine(points5);

        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine);
        ladderLines.add(ladderLine2);
        ladderLines.add(ladderLine3);
        ladderLines.add(ladderLine4);
        ladderLines.add(ladderLine5);
        Lines lines = new Lines(ladderLines);

        laddering = new Laddering(players, lines);

        List<String> result = Arrays.asList("꽝","5000","꽝","3000");
        ladderResult = new LadderResult(result);

        ladderManage = new LadderManage(player, ladderLines);

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
