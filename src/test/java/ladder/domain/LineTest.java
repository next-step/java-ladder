package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void test() {
        Line line = Line.from(4);
        assertThat(line).isNotNull();
    }
}