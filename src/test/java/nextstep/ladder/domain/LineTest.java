package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void create() {
        Line line = new Line();
        assertThat(line).isEqualTo(new Line());
    }

    @Test
    @DisplayName("높이:1 이고, |-----|     |")
    void 라인_존재여부() {
        Line line = new Line(Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
        assertThat(line.hasLineAtPosition(0)).isTrue();
        assertThat(line.hasLineAtPosition(1)).isTrue();
        assertThat(line.hasLineAtPosition(2)).isFalse();
    }
}
