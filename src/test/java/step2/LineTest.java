package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 사다리_라인_생성() {
        //given
        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);
        Point fourth = new Point(true, false);

        List<Point> pointList = Arrays.asList(first, second, third, fourth);
        Line expect = new Line(pointList);

        //when
        Line actual = new Line(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
