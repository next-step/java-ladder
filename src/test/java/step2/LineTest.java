package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 사다리_라인_생성() {
        //given
        Point point1 = new Point(true);
        Point point2 = new Point(false);
        Point point3 = new Point(true);
        Point point4 = new Point(false);
        Line expect = new Line(Arrays.asList(point1, point2, point3, point4));

        //when
        Line actual = new Line(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
