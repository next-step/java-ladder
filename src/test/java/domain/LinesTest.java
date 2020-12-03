package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    void ofTest() {
        Lines lines = Lines.of(Length.of(4), Length.of(3));
        assertThat(lines.mapLineOntoPoints().count()).isEqualTo(3);

    }
}
