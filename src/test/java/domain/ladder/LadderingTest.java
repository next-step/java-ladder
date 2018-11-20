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
        Point first = Point.first(TRUE);
        Point second = first.next(FALSE);
        Point third = second.next(TRUE);
        points1.add(first);
        points1.add(second);
        points1.add(third);
        LadderLine ladderLine = new LadderLine(points1);

        List<Point> points2 = new ArrayList<>();
        Point first2 = Point.first(FALSE);
        Point second2 = first2.next(TRUE);
        Point third2 = second2.next(FALSE);
        points2.add(first2);
        points2.add(second2);
        points2.add(third2);
        LadderLine ladderLine2 = new LadderLine(points2);

        List<Point> points3 = new ArrayList<>();
        Point first3 = Point.first(TRUE);
        Point second3 = first3.next(FALSE);
        Point third3 = second3.next(FALSE);
        points3.add(first3);
        points3.add(second3);
        points3.add(third3);
        LadderLine ladderLine3 = new LadderLine(points3);

        List<Point> points4 = new ArrayList<>();
        Point first4 = Point.first(FALSE);
        Point second4 = first4.next(TRUE);
        Point third4 = second4.next(FALSE);
        points4.add(first4);
        points4.add(second4);
        points4.add(third4);
        LadderLine ladderLine4 = new LadderLine(points4);

        List<Point> points5 = new ArrayList<>();
        Point first5 = Point.first(TRUE);
        Point second5 = first5.next(FALSE);
        Point third5 = second5.next(TRUE);
        points5.add(first5);
        points5.add(second5);
        points5.add(third5);
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
