package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @Test
    void ofTest() {
        line = Line.of(Length.of(3));
        assertThat(line.getPoints().stream().count()).isEqualTo(3);
    }

}
