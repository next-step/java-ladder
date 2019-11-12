package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void vertical() {
        final Line horizontalLine = LineFactory.line(PositiveNumber.of(3));
        final String expected = "---";
        assertThat(horizontalLine.print()).isEqualTo(expected);
    }
}