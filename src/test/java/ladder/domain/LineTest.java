package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 생성_첫번째라인() {
        Line line = Line.ofFirst(true);
        assertThat(line).isEqualTo(Line.ofFirst(true));
    }

    @Test
    void 생성_중간라인() {
        Line line = Line.of(true, false);
        assertThat(line).isEqualTo(Line.of(true, false));
    }

    @Test
    void 생성_마지막라인() {
        Line line = Line.ofLast(true);
        assertThat(line).isEqualTo(Line.ofLast(true));
    }
}
