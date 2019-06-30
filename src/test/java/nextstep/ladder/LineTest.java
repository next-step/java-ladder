package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void Line_만들기 () {
        Line line = new Line(3);
        assertThat(line).isTrue();
    }
}
