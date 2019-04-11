package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LadderTest {

    @Test
    public void 사다리생성() {
        Ladder result = new Ladder(2, 2);
        
        Assertions.assertThat(result.getLines().size()).isEqualTo(2);
        Assertions.assertThat(result.getLines().get(0).getPoints().size()).isEqualTo(2);
        Assertions.assertThat(result.getLines().get(1).getPoints().size()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리생성_실패() {
          new Ladder(3, 1);
    }

    @Test
    public void 이동테스트() {
        Line resultLine1 = new Line(2) {
            @Override
            protected List<Point> initPoints(int countOfPerson) {
                return Arrays.asList(Point.first(false), Point.last(false));
            }
        };

        Line resultLine2 = new Line(2) {
            @Override
            protected List<Point> initPoints(int countOfPerson) {
                return Arrays.asList(Point.first(true), Point.last(true));
            }
        };

        Ladder result = new Ladder(2,(Arrays.asList(resultLine1, resultLine2)));
        
        int moveResult = result.move(0);
        Assertions.assertThat(moveResult).isEqualTo(1);

        moveResult = result.move(1);
        Assertions.assertThat(moveResult).isEqualTo(0);
    }
}