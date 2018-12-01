package ladder.util;

import ladder.model.Point;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LinePointGeneratorTest {

    @Test
    public void 생성() {
        assertThat(LinePointGenerator.generate(5)).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_0개() {
        LinePointGenerator.generate(0);
    }

    @Test
    public void 충돌_방지_검증() {
        List<Point> points = LinePointGenerator.generate(5);
        IntStream.range(1, points.size())
            .forEach(index -> {
                assertThat(points.get(index - 1).isCollapse(points.get(index))).isFalse();
            });
    }
}