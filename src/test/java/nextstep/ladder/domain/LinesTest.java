package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {

    @DisplayName("createLine()은 width 폭, height 높이의 사다리를 만든다.")
    @Test
    void createLines() {
        Lines lines = Lines.createLines(4, 5);

        assertThat(lines.getLines()).hasSize(5);
    }

    @DisplayName("사다리는 0보다 큰 width, height 를 가진다.")
    @Test
    void createLines_Exception() {
        assertThatThrownBy(() -> Lines.createLines(0, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
