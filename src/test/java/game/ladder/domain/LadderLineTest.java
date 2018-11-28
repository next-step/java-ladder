package game.ladder.domain;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    public void 만들기() {
        LadderLine ladderLine = new LadderLine(Arrays.asList(new Point(0, Direction.first(false))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_빈배열() {
        LadderLine ladderLine = new LadderLine(Lists.newArrayList());
    }

    @Test
    public void init() {
        int sizeOfPerson = 5;

        LadderLine ladderLine = LadderLine.init(sizeOfPerson);

        assertThat(ladderLine.pointSize()).isEqualTo(sizeOfPerson);
    }

    @Test(expected = IllegalArgumentException.class)
    public void init_참여자수_0일때() {
        final int zeroPerson = 0;

        LadderLine.init(zeroPerson);
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);

        line.move(0);
        line.move(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void move_최대position_넘은값() {
        LadderLine line = LadderLine.init(2);

        line.move(line.pointSize());
    }

    @Test
    public void getStringLadderLine() {
        final String expected = "     |-----|     |";
        final Point first = Point.first(true);
        final Point second = first.next(false);
        final Point last = second.last();
        List<Point> points = Arrays.asList(first, second, last);
        LadderLine ladderLine = new LadderLine(points);

        String stringLadderLine = ladderLine.getStringLadderLine();

        assertThat(stringLadderLine).isEqualTo(expected);
    }

}