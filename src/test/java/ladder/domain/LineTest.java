package ladder.domain;

import ladder.domain.ladder.LadderPoint;
import ladder.domain.ladder.Line;
import ladder.domain.player.People;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @Before
    public void setUp() throws Exception {
        line = new Line();
    }

    @Test
    public void 겹치는_라인() {
        line.isNotValidateLine(true, true);
        assertThat(line.isNotValidateLine(true, true)).isEqualTo(true);
    }

    @Test
    public void 겹치지_않는_라인() {
        line.isNotValidateLine(true, true);
        assertThat(line.isNotValidateLine(false, true)).isEqualTo(false);
        assertThat(line.isNotValidateLine(true, false)).isEqualTo(false);
    }

    @Test
    public void makeLineTest_첫번째Posiiton() {
        People people = new People("a,b,c");
        LadderPoint ladderPoint = line.makePoint(people, 0, true);
        assertThat(ladderPoint).isEqualTo(new LadderPoint(0, true));
    }

    @Test
    public void makeLineTest_겹치는Posiiton() {
        People people = new People("a,b,c,d");
        List<LadderPoint> ladderPointList = line.getLadderPoints();
        ladderPointList.add(line.makePoint(people, 0, false));
        ladderPointList.add(line.makePoint(people, 1, true));
        LadderPoint ladderPoint = line.makePoint(people, 2, true);
        assertThat(ladderPoint).isEqualTo(new LadderPoint(2, false));
    }

    @Test
    public void makeLineTest_마지막Posiiton() {
        People people = new People("a,b,c");
        LadderPoint ladderPoint = line.makePoint(people, 2, true);
        assertThat(ladderPoint).isEqualTo(new LadderPoint(2, false));
    }

}