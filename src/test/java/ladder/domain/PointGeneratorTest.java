package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointGeneratorTest {

    private PointGenerator pointGenerator;

    @Test
    public void 생성테스트() {
        pointGenerator = new PointGenerator();
        List<Point> result = pointGenerator.generate(3);
        assertThat(result.size()).isEqualTo(3);
    }
}
