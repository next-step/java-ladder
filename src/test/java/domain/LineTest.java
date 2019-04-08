package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

public class LineTest {

    @Test(expected = RuntimeException.class)
    public void invalid_아무_이동_없음() {
        new Line(Arrays.asList(
                new Point(0, DirectionType.NONE),
                new Point(1, DirectionType.NONE),
                new Point(2, DirectionType.NONE)));
    }

    @Test
    public void paint() {
        final Point first = Point.first(Movable.TRUE);
        final Point second = first.next(Movable.FALSE);
        final Line line = new Line(Arrays.asList(
                first,
                second,
                second.last()));
        final int spacingLetterLength = 5;

        String lineLooks = line.paint(spacingLetterLength);
        String expected = Line.BAR
                + StringUtils.repeat(Line.LINE_LOOKS, spacingLetterLength) + Line.BAR
                + StringUtils.repeat(Line.LINE_LOOKS_NONE, spacingLetterLength) + Line.BAR;

        assertThat(lineLooks).isEqualTo(expected);
    }

    @Test
    public void move() {
        final Point first = Point.first(Movable.TRUE);
        final Point second = first.next(Movable.FALSE);

        final Line line = new Line(Arrays.asList(
                first,
                second,
                second.last()));

        assertThat(line.positionAfterMove(0)).isEqualTo(1);
        assertThat(line.positionAfterMove(1)).isEqualTo(0);
        assertThat(line.positionAfterMove(2)).isEqualTo(2);
    }
}