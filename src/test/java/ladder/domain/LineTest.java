package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LineTest {

    @Test
    public void 라인그리기_테스트() {
        Line result = new Line(2) {
            @Override
            protected List<Point> initPoints(int countOfPerson) {
                return Arrays.asList(Point.first(true), Point.last(true));
            }
        };
        Assertions.assertThat(result.getPoints()).isEqualTo(Arrays.asList(Point.first(true), Point.last(true)));
        Assertions.assertThat(result.getPoints().size()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 라인그리기_실패_테스트() {
        new Line(1);
    }


}