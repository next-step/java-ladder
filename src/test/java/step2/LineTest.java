package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 사다리_라인_생성() {
        //given
        Point expectPoint1 = new Point(0, true);
        Point expectPoint2 = new Point(1, false);
        Point expectPoint3 = new Point(2, true);
        Point expectPoint4 = new Point(3, false);
        Line expect = new Line(Arrays.asList(expectPoint1, expectPoint2, expectPoint3, expectPoint4));

        //when
        Line actual = new Line(4, () -> true);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void 라인_교환_결과_확인() {
        //given
        Point expectPoint1 = new Point(1, false);
        Point expectPoint2 = new Point(0, true);
        Point expectPoint3 = new Point(3, false);
        Point expectPoint4 = new Point(2, true);

        //when
        Line line = new Line(4, () -> true);
        line.getResult();

        //then
        assertThat(line).isEqualTo(new Line(Arrays.asList(expectPoint1, expectPoint2, expectPoint3, expectPoint4)));
    }
}
