package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("createLine()은 width 길이의 라인을 height개 만든다.")
    @Test
    void createLines() {
        Lines lines = Lines.createLines(4, 5);

        assertThat(lines.getLines()).hasSize(5);
    }
}