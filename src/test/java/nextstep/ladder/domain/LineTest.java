package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("객체 생성이 잘 되는지")
    @Test
    void create() {
        Line line = Line.createLine(5);
        assertThat(line).isNotNull();
    }

}
