package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineRandomTest {

    @Test
    void 라인을_생성한다() {
        // given
        LineCreateStrategy strategy = new LineRandom();

        // when
        List<Point> result = strategy.create(4);

        // then
        assertThat(result.size()).isEqualTo(4);
    }
}
