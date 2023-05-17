package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void 무조건_다리를_생성한다() {
        Line line = new Line(5, () -> true);
        assertThat(line.getBridges()).hasSize(4);
        long count = line.getBridges().stream()
                .filter(b -> b == true)
                .count();
        assertThat(count).isEqualTo(4);
    }

    @Test
    void 무조건_다리를_생성하지_않는다() {
        Line line = new Line(5, () -> false);
        assertThat(line.getBridges()).hasSize(4);
        long count = line.getBridges().stream()
                .filter(b -> b == true)
                .count();
        assertThat(count).isEqualTo(0);
    }
}