package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointGeneratorTest {

    private PointGenerator pointGenerator;

    @Test
    public void 생성테스트() {
        pointGenerator = new PointGenerator() {
            @Override
            public List<Point> generate(int countOfPerson) {
                return Arrays.asList(Point.first(true), new Point(true, false), Point.last(false));
            }
        };

        List<Point> result = pointGenerator.generate(3);
        
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).isEqualTo(Arrays.asList(Point.first(true), new Point(true, false), Point.last(false)));
    }
}
