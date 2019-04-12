package ladder.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointGeneratorTest {

    @Test
    public void 생성테스트() {
        List<Point> result = PointGenerator.generate(3, LEVEL.LOW);
        assertThat(result.size()).isEqualTo(3);
    }
}
