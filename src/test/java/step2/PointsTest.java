package step2;

import org.junit.jupiter.api.Test;
import step2.model.Point;
import step2.model.Points;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PointsTest {
    @Test
    public void 포인트_전체_생성() {
        //given
        Point first = new Point(false, true);
        Point second = new Point(true, false);
        Point third = new Point(false, true);
        Point fourth = new Point(true, false);

        Points expect = new Points(Arrays.asList(first, second, third, fourth));

        //when
        Points actual = new Points(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
