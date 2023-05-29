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
        assertThat(line.value().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 라인이_겹치지_않는지_확인(int idx) {
        Boolean prevPoint = line.value().get(idx - 1);
        Boolean currPoint = line.value().get(idx);

        if (prevPoint)
            assertThat(true).isNotEqualTo(currPoint);
    }
}
