package game.ladder.domain;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 직접만들기() {
        Point point = new Point(0, Direction.first(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 직접만들기_인덱스_0보다_작을때() {
        Point point = new Point(-1, Direction.first(false));
    }

    @Test
    public void first() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void getStringPoint_첫번째_오른쪽_채워짐() {
        final String expected = "     |-----";
        final boolean last = false;
        final boolean lineRight = true;
        final Point linePoint = Point.first(lineRight);

        String line = linePoint.getStringPoint(last);
        assertThat(line).isEqualTo(expected);
    }

    @Test
    public void getStringPoint_첫번째_오른쪽_비워짐() {
        final String expected = "     |     ";
        final boolean last = false;
        final boolean emptyRight = false;
        final Point emtpyPoint = Point.first(emptyRight);

        String line = emtpyPoint.getStringPoint(last);
        assertThat(line).isEqualTo(expected);
    }

    @Test
    public void getStringPoint_마지막() {
        final String expected = "|";
        final boolean last = true;
        final Point lastPoint = new Point(0, Direction.first(true)).last();

        String lastString = lastPoint.getStringPoint(last);

        assertThat(lastString).isEqualTo(expected);
    }

    @Test
    public void getStringPoint_첫번째_마지막_아닐때_오른쪽_채움() {
        final String expected = "|-----";
        final boolean last = false;
        final boolean lineRight = true;
        final Point point = Point.first(!lineRight).next(lineRight);

        String stringPoint = point.getStringPoint(last);

        assertThat(stringPoint).isEqualTo(expected);
    }

    @Test
    public void getStringPoint_첫번째_마지막_아닐때_오른쪽_비움() {
        final String expected = "|     ";
        final boolean last = false;
        final boolean emptyRight = false;
        final Point point = Point.first(!emptyRight).next(emptyRight);

        String stringPoint = point.getStringPoint(last);

        assertThat(stringPoint).isEqualTo(expected);
    }
}