package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void ofTest() {
        Line line = Line.of(Length.of(3));
        assertThat(line.getPoints().stream().count()).isEqualTo(3);
    }
}
