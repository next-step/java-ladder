package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    void setup() {
        line = new Line(4);
    }

    @Test
    void create() {
        assertThat(line.points().size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 라인이_겹치지_않는지_확인(int idx) {
        Boolean prevPoint = line.points().get(idx - 1);
        Boolean currPoint = line.points().get(idx);

        if (prevPoint)
            assertThat(true).isNotEqualTo(currPoint);
    }
}
