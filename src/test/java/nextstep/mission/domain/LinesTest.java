package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    void constructor() {
        assertThat(new Lines(1, 10)).isNotNull();
    }

    @Test
    void getLine() {
        Lines lines = new Lines(1, 1);
        assertThat(lines.getLine(0)).isNotNull();
        assertThat(lines.getLine(1)).isNull();
    }

    @Test
    void checkHeight() {
        Lines lines = new Lines(1, 1);
        assertThat(lines.checkHeight(1)).isTrue();
        assertThat(lines.checkHeight(2)).isFalse();
    }
}
